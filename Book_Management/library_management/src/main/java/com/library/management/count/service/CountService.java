package com.library.management.count.service;

import com.library.management.book.repository.BookRepository;
import com.library.management.count.domain.Count;
import com.library.management.count.repository.CountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountService {

    @Autowired
    public CountRepository countRepository;

    @Autowired
    public BookRepository bookRepository;

    public List<Count> getAllCount(){
        return countRepository.findAll();
    }

    public Optional<Count> getCountById(long countId){
        return countRepository.findById(countId);
    }

    public Count createCount(Count count){
        return countRepository.save(count);
    }

    public List<Count> getBookCount(String book){
        return countRepository.findByPartialBookName(book);
    }

}
