package com.library.management.library.service;

import com.library.management.book.repository.BookRepository;
import com.library.management.library.domain.Library;
import com.library.management.library.dto.LibraryDto;
import com.library.management.library.exception.LibraryIdExistsException;
import com.library.management.library.exception.LibraryPincodeExistsException;
import com.library.management.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    public LibraryRepository libraryRepository;

    @Autowired
    public BookRepository bookRepository;


    @Override
    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    @Override
    public Optional<Library> getLibraryById(long libId) {
        return libraryRepository.findById(libId);
    }

    @Override
    public Optional<Library> getLibraryByName(String name) {
        return libraryRepository.findByName(name);
    }

    @Override
    public Library createLibrary(LibraryDto library) {
        libraryRepository
                .findById(library.libId())
                .ifPresent(lib -> {
                    throw new LibraryIdExistsException("A library exists with this ID  " + library.libId());});

        libraryRepository
                .findByPincode(library.pincode())
                .ifPresent(lib -> {throw new LibraryPincodeExistsException("A library already exists in this pincode");
                });

        Library library1 = new Library();

        library1.setLibId(library.libId());
        library1.setName(library.name());
        library1.setPincode(library.pincode());
        library1.setCity(library.city());

//        List<Book> books = bookRepository.findByLibrary(library1);

//        library1.setBooks(books);

        libraryRepository.save(library1);
        return library1;
    }

}
