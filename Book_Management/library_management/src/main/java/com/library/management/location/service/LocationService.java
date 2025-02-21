package com.library.management.location.service;

import com.library.management.book.domain.Book;
import com.library.management.location.domain.Location;
import com.library.management.location.dto.LocationResponse;

import java.util.List;

public interface LocationService {

    public List<Location> getAllLocations();

    public Location addLocation(Location location);

//    public List<Book> getBooks(long locationId);

    public LocationResponse getLocationByBookId(String bookId);
}
