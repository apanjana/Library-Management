package com.library.management.location.dto;

import com.library.management.book.domain.Book;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LocationResponse {

    public String location;
    private Book book;

}
