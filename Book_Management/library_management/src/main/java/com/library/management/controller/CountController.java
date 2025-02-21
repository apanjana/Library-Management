package com.library.management.controller;

import com.library.management.book.domain.Book;
import com.library.management.count.domain.Count;
import com.library.management.count.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/count")
public class CountController {

    @Autowired
    public CountService countService;

    @PostMapping
    public Count createCount(@RequestBody Count count){
        return countService.createCount(count);
    }

    @GetMapping
    public List<Count> getAllCount(){
        return countService.getAllCount();
    }

    @GetMapping("/{countId}")
    public Optional<Count> getCountById(@PathVariable long countId){
        return countService.getCountById(countId);
    }

    @GetMapping("/bookname/{book}")
    public List<Count> getBookCount(@PathVariable String book){
        return countService.getBookCount(book);
    }

}
