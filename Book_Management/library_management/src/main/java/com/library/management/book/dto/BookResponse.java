package com.library.management.book.dto;

import lombok.*;

import java.util.Date;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

//Customized response type for user to understand better
public class BookResponse {

    public String bookName;
    public String author;
    public String genre;
    public String description;
    public Date published;
    public String publisherName;
    public String libName;
    public String libPincode;
    public String libCity;
    public String location;
    public String category;
//    public int count;

    public BookResponse(String bookName, String author, String genre, String description, Date published, String publisherName, String libName, String libPincode, String libCity, String category, String location) {
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.published = published;
        this.publisherName = publisherName;
        this.libName = libName;
        this.libPincode = libPincode;
        this.libCity = libCity;
        this.category = category;
        this.location = location;

//        this.count = count;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getLibName() {
        return libName;
    }

    public void setLibName(String libName) {
        this.libName = libName;
    }

    public String getLibPincode() {
        return libPincode;
    }

    public void setLibPincode(String libPincode) {
        this.libPincode = libPincode;
    }

    public String getLibCity() {
        return libCity;
    }

    public void setLibCity(String libCity) {
        this.libCity = libCity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
}
