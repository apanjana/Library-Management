package com.library.management.count.domain;

import com.library.management.book.domain.Book;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Count {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long countId;
    public int total;
    public int avail;
    public int taken;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

//    @OneToOne
//    @JoinColumn(name = "count_id")
//    private Count count;


    public long getCountId() {
        return countId;
    }

    public void setCountId(long countId) {
        this.countId = countId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAvail() {
        return avail;
    }

    public void setAvail(int avail) {
        this.avail = avail;
    }

    public int getTaken() {
        return taken;
    }

    public void setTaken(int taken) {
        this.taken = taken;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
