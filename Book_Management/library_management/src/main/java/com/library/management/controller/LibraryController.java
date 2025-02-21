package com.library.management.controller;

import com.library.management.library.domain.Library;
import com.library.management.library.dto.LibraryDto;
import com.library.management.library.service.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    public LibraryServiceImpl libraryService;

    @GetMapping("")
    public List<Library> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @GetMapping("/id/{libId}")
    public Optional<Library> getLibraryById(@PathVariable long libId) {
        return libraryService.getLibraryById(libId);
    }

    @GetMapping("/{libName}")
    public Optional<Library> getLibraryByName(@PathVariable String libName){
        return libraryService.getLibraryByName(libName);
    }

    @PostMapping
    public Library createLibrary(@RequestBody LibraryDto library) {
        return libraryService.createLibrary(library);
    }

}
