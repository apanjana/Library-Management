package com.library.library_management.library_service.service;

import com.library.library_management.library_service.domain.Library;
import com.library.library_management.library_service.dto.LibraryDto;
import com.library.library_management.library_service.exception.LibraryLocationExistsException;
import com.library.library_management.library_service.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    public LibraryRepository libraryRepository;


    @Override
    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    @Override
    public Optional<Library> getLibraryById(long libId) {
        return libraryRepository.findById(libId);
    }

    @Override
    public Library createLibrary(LibraryDto library) {
        libraryRepository
                .findById(library.libId())
                .ifPresent(lib -> {
                    throw new RuntimeException("A library exists with this ID  " + library.libId());});

        libraryRepository
                .findByLocation(library.location())
                .ifPresent(lib -> {throw new LibraryLocationExistsException("A library already exists in this location");
                });

        Library library1 = new Library();

        library1.setLibId(library.libId());
        library1.setName(library.name());
        library1.setLocation(library.location());

        libraryRepository.save(library1);
        return library1;
    }

}
