package com.library.management.book.service;

import com.library.management.book.domain.Book;
import com.library.management.book.dto.BookDto;
import com.library.management.book.dto.BookResponse;
import com.library.management.book.dto.BookSearch;

import java.util.List;

public interface BookService {

    public List<Book> getAllBooks();

    public List<BookResponse> createBook(List<BookDto> book);

    public List<BookResponse> getBook(BookSearch book);

//    public List<Book> getBooksByLocation(long locationId);

//    public List<Book> addManyBooks(List<Book> books);
}
