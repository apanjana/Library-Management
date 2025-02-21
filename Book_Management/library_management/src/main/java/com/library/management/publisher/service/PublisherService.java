package com.library.management.publisher.service;

import com.library.management.publisher.domain.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {

    public Publisher addPublisher(Publisher publisher);

    public Optional<Publisher> getPublisherById(long publisherId);

    public List<Publisher> getAllPublishers();

    public Publisher getPublisherByName(String publisherName);

//    public Publisher gePublisherByBookName(String bookName);

}
