package com.library.management.publisher.service;

import com.library.management.publisher.domain.Publisher;
import com.library.management.publisher.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    public PublisherRepository publisherRepository;


    @Override
    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Optional<Publisher> getPublisherById(long publisherId) {
        return publisherRepository.findById(publisherId);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisherByName(String publisherName) {
        return publisherRepository.findByPublisherName(publisherName);
    }

//    @Override
//    public Publisher gePublisherByBookName(String bookName) {
//        return publisherRepository.findByBook_BookName(bookName);
//    }


}
