package com.library.management.publisher.repository;

import com.library.management.publisher.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {

    Publisher findByPublisherName(String publisherName);

//    Publisher findByBook_BookName(String bookName);

}
