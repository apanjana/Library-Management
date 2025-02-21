package com.library.library_management.library_service.controller;

import com.library.library_management.library_service.domain.Library;
import com.library.library_management.library_service.dto.LibraryDto;

import java.util.List;
import java.util.Optional;

public interface LibraryController {

    public List<Library> getAllLibraries();

    public Optional<Library> getLibraryById(long libId);

    public Library createLibrary(LibraryDto library);


}
