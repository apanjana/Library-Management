package com.library.management.book.service;

import com.library.management.book.domain.Book;
import com.library.management.book.dto.BookDto;
import com.library.management.book.dto.BookResponse;
import com.library.management.book.dto.BookSearch;
import com.library.management.book.exception.BookExistsCheckException;
import com.library.management.book.repository.BookRepository;
import com.library.management.category.domain.Category;
import com.library.management.category.repository.CategoryRepository;
import com.library.management.library.domain.Library;
import com.library.management.library.repository.LibraryRepository;
import com.library.management.location.domain.Location;
import com.library.management.location.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookServiceImpl implements BookService{

    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public LibraryRepository libraryRepository;

    @Autowired
    public LocationRepository locationRepository;

    @Autowired
    public CategoryRepository categoryRepository;

    //Returns list of all books in the library
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //Filters books as per user requirement and returns a list of books
    @Override
    public List<BookResponse> getBook(BookSearch bookSearch) {
        log.info("Searching for books with criteria: {}", bookSearch);

        if (bookSearch.getLibId() <= 0) {
            log.error("Invalid Library ID (libId): {}", bookSearch.getLibId());
            throw new IllegalArgumentException("Library ID must be given");
        }

        //Filters books using a custom JPA query in the book repository
        List<Book> books = bookRepository.findBooksByCriteria(
                bookSearch.getLibId(),
                bookSearch.getBookId(),
                bookSearch.getBookName(),
                bookSearch.getAuthor(),
                bookSearch.getGenre(),
                bookSearch.getPublisherName());

        if (books.isEmpty()) {
            log.error("No books found with the given criteria: {}", bookSearch);
            throw new BookExistsCheckException("No books found with the given search criteria.");
        }

        log.info("Returning {} books after filtering.", books.size());

//        return books.stream()
//                .map(book -> new BookResponse(
//                        book.getBookName(),
//                        book.getAuthor(),
//                        book.getGenre(),
//                        book.getDescription(),
//                        book.getPublished(),
//                        book.getPublisherName(),
//                        book.getLibrary().getName(),
//                        book.getLibrary().getPincode(),
//                        book.getLibrary().getCity(),
//                        book.getCategory().getGenre()
//                ))
//                .collect(Collectors.toList());

        return books.stream()
                .map(book -> {
                    // Fetch location using locationRepository
                    Location location = locationRepository.findByBook_BookId(book.getBookId());

                    // Format the location
                    String formattedLocation = (location != null)
                            ? String.format("S%04dR%04dC%04d", location.getLocShelf(), location.getLocRow(), location.getLocColumn())
                            : "Location Not Available";

                    // Return BookResponse with formatted location
                    return new BookResponse(
                            book.getBookName(),
                            book.getAuthor(),
                            book.getGenre(),
                            book.getDescription(),
                            book.getPublished(),
                            book.getPublisherName(),
                            book.getLibrary().getName(),
                            book.getLibrary().getPincode(),
                            book.getLibrary().getCity(),
                            book.getCategory().getGenre(),
                            formattedLocation
                    );
                })
                .collect(Collectors.toList());

    }


    //Adds books to the library
    @Override
    public List<BookResponse> createBook(List<BookDto> bookDtos) {
        log.debug("Processing {} book(s) for creation or update.", bookDtos.size());

        // Process each book in the input list
        List<Book> savedBooks = bookDtos.stream().map(bookDto -> {
            // Check if a book with the same name already exists
            Book existingBook = bookRepository.findByBookName(bookDto.bookName()).orElse(null);

            if (existingBook != null) {
                log.warn("Book with name '{}' already exists. Updating the existing book.", bookDto.bookName());
                return updateBook(bookDto, existingBook);
            }

            // Create a new book if it doesn't exist
            Book newBook = new Book();
            newBook.setBookId(bookDto.bookId());
            return updateBook(bookDto, newBook);
        }).collect(Collectors.toList());

        // Map the saved books to BookResponse DTOs
        List<BookResponse> bookResponses = savedBooks.stream().map(this::mapToBookResponse).collect(Collectors.toList());

        log.info("Successfully processed {} book(s).", bookResponses.size());
        return bookResponses;
    }

    // Method to map Book entity to BookResponse DTO
    private BookResponse mapToBookResponse(Book book) {
        Location location = locationRepository.findByBook_BookId(book.getBookId());
        String formattedLocation = (location != null)
                ? String.format("S%04dR%04dC%04d", location.getLocShelf(), location.getLocRow(), location.getLocColumn())
                : "Location Not Available";
        return new BookResponse(
                book.getBookName(),
                book.getAuthor(),
                book.getGenre(),
                book.getDescription(),
                book.getPublished(),
                book.getPublisherName(),
                book.getLibrary().getName(),
                book.getLibrary().getPincode(),
                book.getLibrary().getCity(),
                book.getCategory().getGenre(),
                formattedLocation
        );
    }

    private Book updateBook(BookDto bookDto, Book book) {
        log.debug("Updating book details: {}", bookDto);

        log.info("Fetching library with ID: {}", bookDto.library().libId);
        Library library = libraryRepository.findById(bookDto.library().libId)
                .orElseThrow(() -> {
                    log.error("Library not found with ID: {}", bookDto.library().libId);
                    return new RuntimeException("Library not found with this ID");
                });

        log.info("Fetching category with ID: {}", bookDto.category().categoryId);
        Category category = categoryRepository.findById(bookDto.category().categoryId)
                .orElseThrow(() -> {
                    log.error("Category not found with ID: {}", bookDto.category().categoryId);
                    return new RuntimeException("Category not found with this ID");
                });

        book.setBookName(bookDto.bookName());
        book.setAuthor(bookDto.author());
        book.setGenre(bookDto.genre());
        book.setDescription(bookDto.description());
        book.setPublished(bookDto.published());
        book.setPublisherName(bookDto.publisherName());
        book.setLibrary(library);
        book.setCategory(category);

        log.info("Saving book with ID: {}", book.getBookId());
        return bookRepository.save(book);
    }


}
