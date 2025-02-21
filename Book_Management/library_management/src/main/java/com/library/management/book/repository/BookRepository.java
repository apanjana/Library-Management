package com.library.management.book.repository;

import com.library.management.book.domain.Book;
//import com.library.management.library.domain.Library;
import com.library.management.publisher.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String> {

    @Query("SELECT b FROM Book b WHERE LOWER(b.bookName) LIKE LOWER(CONCAT('%', :bookName, '%'))")
    List<Book> findByPartialBookName(String bookName);

    Optional<Book> findByBookName(String bookName);

//    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

    @Query("SELECT b FROM Book b WHERE LOWER(b.publisherName) LIKE LOWER(CONCAT('%', :publisherName, '%'))")
    List<Book> findByPublisherName(String publisherName);

    List<Book> findByLibrary_LibId(Long libId);

    @Query("SELECT b FROM Book b WHERE LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%'))")
    List<Book> findByPartialAuthor(String author);

    @Query("SELECT b FROM Book b WHERE LOWER(b.library.name) LIKE LOWER(CONCAT('%', :libraryName, '%'))")
    List<Book> findByLibraryName(String libraryName);

//    List<Book> findByLocation_LocationId(long locationId);

//    Book findByPublisherName(String publisherName);


    @Query("SELECT b FROM Book b " +
            "WHERE (b.library.libId = :libId OR :libId IS NULL) " +
            "AND (b.bookId = :bookId OR :bookId IS NULL) " +
            "AND (LOWER(b.bookName) LIKE LOWER(CONCAT('%', :bookName, '%')) OR :bookName IS NULL) " +
            "AND (LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%')) OR :author IS NULL) " +
            "AND (b.genre = :genre OR :genre IS NULL) " +
            "AND (LOWER(b.publisherName) LIKE LOWER(CONCAT('%', :publisherName, '%')) OR :publisherName IS NULL) ")
    List<Book> findBooksByCriteria(@Param("libId") Long libId,
                                   @Param("bookId") String bookId,
                                   @Param("bookName") String bookName,
                                   @Param("author") String author,
                                   @Param("genre") String genre,
                                   @Param("publisherName") String publisherName);



//    List<Book> findByLibrary(Library libId);

}
