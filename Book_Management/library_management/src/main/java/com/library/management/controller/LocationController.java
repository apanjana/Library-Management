package com.library.management.controller;

import com.library.management.book.domain.Book;
import com.library.management.location.domain.Location;
import com.library.management.location.dto.LocationResponse;
import com.library.management.location.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    public LocationServiceImpl locationService;

    @GetMapping("")
    public List<Location> getAllLocations(){
        return locationService.getAllLocations();
    }

    @PostMapping("")
    public Location addLocation(@RequestBody Location location){
        return locationService.addLocation(location);
    }

    @GetMapping("/{bookId}")
    public LocationResponse getLocationByBookId(@PathVariable String bookId){
        return locationService.getLocationByBookId(bookId);
    }

//    @GetMapping("/{locationId}")
//    public List<Book> getBooks(@PathVariable long locationId){
//        return locationService.getBooks(locationId);
//    }

}
