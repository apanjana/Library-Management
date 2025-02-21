package com.library.management.controller;

import com.library.management.publisher.domain.Publisher;
import com.library.management.publisher.service.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    public PublisherServiceImpl publisherService;

    @PostMapping("")
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherService.addPublisher(publisher);
    }

    @GetMapping("/{publisherId}")
    public Optional<Publisher> getPublisherById(@PathVariable long publisherId) {
        return publisherService.getPublisherById(publisherId);
    }

    @GetMapping("")
    public List<Publisher> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/name/{publisherName}")
    public Publisher getPublisherByName(@PathVariable String publisherName) {
        return publisherService.getPublisherByName(publisherName);
    }

//    @GetMapping("/book/bookName")
//    public Publisher getPublisherByBookName(@PathVariable String bookName){
//        return publisherService.gePublisherByBookName(bookName);
//    }

}
