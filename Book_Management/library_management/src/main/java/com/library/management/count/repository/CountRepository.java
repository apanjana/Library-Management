package com.library.management.count.repository;

import com.library.management.book.domain.Book;
import com.library.management.count.domain.Count;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CountRepository extends JpaRepository<Count,Long> {

    Optional<Count> findByBook_BookId(String book);

    @Query("SELECT b FROM Count b WHERE LOWER(b.book.bookName) LIKE LOWER(CONCAT('%', :bookName, '%'))")
    List<Count> findByPartialBookName(String bookName);

}
