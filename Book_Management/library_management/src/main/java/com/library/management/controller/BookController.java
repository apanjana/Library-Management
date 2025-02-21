package com.library.management.controller;

import com.library.management.book.domain.Book;
import com.library.management.book.dto.BookDto;
import com.library.management.book.dto.BookResponse;
import com.library.management.book.dto.BookSearch;
import com.library.management.book.service.BookServiceImpl;
import com.library.management.publisher.domain.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    public BookServiceImpl bookService;

    //Returns list of all books
    @GetMapping("")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    //Returns list of filtered books
    @PostMapping("/search")
    public List<BookResponse> getBook(@RequestBody BookSearch book){
        return bookService.getBook(book);
    }

    //Adds book to library
    @PostMapping("/add")
    public List<BookResponse> createBook(@RequestBody List<BookDto> book){
        return bookService.createBook(book);
    }

//    @PostMapping("/addM")
//    public List<Book> addManyBooks(@RequestBody List<BookDto> books) {
//        return bookService.addManyBooks(books);
//    }

}
