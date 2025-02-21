package com.library.management.book.dto;

import com.library.management.book.domain.Book;
import com.library.management.category.domain.Category;
import com.library.management.count.domain.Count;
import com.library.management.library.domain.Library;
import com.library.management.location.domain.Location;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

//Performs validation
public record BookDto(
        @NotNull(message = "Book ID must not be null")
        String bookId,

        @NotNull(message = "A book without a name?! Please give it a name.")
        @Size(min = 3, message = "Book's name must be at least 3 characters long")
        String bookName,

        @NotNull(message = "How can a book not have an author?!")
        @Size(min = 2, message = "Author's name must be at least 2 characters long")
        String author,

        @NotNull(message = "Please categorize the book into a valid genre")
        String genre,

        String description,
        Date published,
        String publisherName,
        Library library,
//        Location location,
        Category category
//        Count count

) {

    //To perform validation, converts Book object to a BookDto object
    public static BookDto bookDto(Book book){
        return new BookDto(book.getBookId(), book.getBookName(),
                book.getAuthor(), book.getGenre(),
                book.getDescription(), book.getPublished(), book.getPublisherName(), book.getLibrary(),book.getCategory());
    }

    //After performing validation, converts BookDto object back to Book object (if no errors found)
//    public Book toBook(Library library){
//        return new Book(bookId,bookName,author,genre,description,published,publisherName,library,category);
//    }

}
