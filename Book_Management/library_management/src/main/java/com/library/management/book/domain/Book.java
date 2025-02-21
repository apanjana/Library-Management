package com.library.management.book.domain;

import com.library.management.category.domain.Category;
import com.library.management.count.domain.Count;
import com.library.management.library.domain.Library;
import com.library.management.location.domain.Location;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

//@Setter
//@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Transactional
public class Book {

    @Id
    @GeneratedValue(generator = "CustomIdGenerator")
    @GenericGenerator(
            name = "CustomIdGenerator",
            strategy = "com.library.management.book.generator.CustomIdGenerator"
    )
    private String bookId;


    public String bookName;
    public String author;
    public String genre;
    public String description;
    public Date published;
    public String publisherName;

    @ManyToOne
    @JoinColumn(name = "lib_id")
    private Library library;

//    @ManyToOne
//    @JoinColumn(name = "location_id")
//    private Location location;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    @OneToOne
//    @JoinColumn(name = "count_id")
//    private Count count;

//    public String getBookId() {
//        return bookId;
//    }
//
//    public void setBookId(String bookId) {
//        this.bookId = bookId;
//    }
//
//    public String getBookName() {
//        return bookName;
//    }
//
//    public void setBookName(String bookName) {
//        this.bookName = bookName;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Date getPublished() {
//        return published;
//    }
//
//    public void setPublished(Date published) {
//        this.published = published;
//    }
//
//    public String getPublisherName() {
//        return publisherName;
//    }
//
//    public void setPublisherName(String publisherName) {
//        this.publisherName = publisherName;
//    }
//
//    public Library getLibrary() {
//        return library;
//    }
//
//    public void setLibrary(Library library) {
//        this.library = library;
//    }
//
//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public Count getCount() {
//        return count;
//    }
//
//    public void setCount(Count count) {
//        this.count = count;
//    }
}
