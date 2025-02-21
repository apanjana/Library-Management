package com.library.library_management.library_service.controller;

import com.library.library_management.library_service.domain.Library;
import com.library.library_management.library_service.dto.LibraryDto;
import com.library.library_management.library_service.service.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class LibraryControllerImpl implements LibraryController{

    @Autowired
    public LibraryServiceImpl libraryService;

    @Override
    @GetMapping("")
    public List<Library> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @Override
    @GetMapping("/{libId}")
    public Optional<Library> getLibraryById(@PathVariable long libId) {
        return libraryService.getLibraryById(libId);
    }

    @Override
    @PostMapping
    public Library createLibrary(@RequestBody LibraryDto library) {
        return libraryService.createLibrary(library);
    }
}
