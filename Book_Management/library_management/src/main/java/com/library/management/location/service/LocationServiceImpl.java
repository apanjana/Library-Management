package com.library.management.location.service;

import com.library.management.book.domain.Book;
import com.library.management.book.repository.BookRepository;
import com.library.management.location.domain.Location;
import com.library.management.location.dto.LocationResponse;
import com.library.management.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    public LocationRepository locationRepository;

    @Autowired
    public BookRepository bookRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public LocationResponse getLocationByBookId(String bookId){

        Location location = locationRepository.findByBook_BookId(bookId);

        return new LocationResponse(String.format("S%03dR%03dC%03d",
                location.getLocShelf(),
                location.getLocRow(),
                location.getLocColumn()), location.getBook());
    }

    @Override
    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

//    @Override
//    public List<Book> getBooks(long locationId){
//        return bookRepository.findByLocation_LocationId(locationId);
//    }
}
