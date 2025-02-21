package com.library.management.location.repository;

import com.library.management.book.domain.Book;
import com.library.management.location.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {


    Location findByBook_BookId(String bookId);

}
