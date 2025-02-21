package com.library.management.library.service;

import com.library.management.library.domain.Library;
import com.library.management.library.dto.LibraryDto;

import java.util.List;
import java.util.Optional;

public interface LibraryService {

    public List<Library> getAllLibraries();

    public Optional<Library> getLibraryById(long libId);

    public Library createLibrary(LibraryDto library);

    public Optional<Library> getLibraryByName(String name);

}
