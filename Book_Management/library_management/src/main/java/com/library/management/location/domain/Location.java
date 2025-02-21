package com.library.management.location.domain;

import com.library.management.book.domain.Book;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long locationId;
    public int locShelf;
    public int locRow;
    public int locColumn;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "bookId") // Join column refers to Book's primary key
    private Book book;

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public int getLocShelf() {
        return locShelf;
    }

    public void setLocShelf(int locShelf) {
        this.locShelf = locShelf;
    }

    public int getLocRow() {
        return locRow;
    }

    public void setLocRow(int locRow) {
        this.locRow = locRow;
    }

    public int getLocColumn() {
        return locColumn;
    }

    public void setLocColumn(int locColumn) {
        this.locColumn = locColumn;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
