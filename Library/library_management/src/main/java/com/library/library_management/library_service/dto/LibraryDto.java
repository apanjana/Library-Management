package com.library.library_management.library_service.dto;

import com.library.library_management.library_service.domain.Library;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record LibraryDto(
        @NotNull(message = "Library ID must not be null")
        long libId,

        @NotNull(message = "Library must have a name")
        @Size(min = 3, message = "Library name must be at least 3 characters long")
        String name,

        @NotNull(message = "Library location cannot be null")
        @Size(min = 2, message = "Library name must be at least 2 characters long")
        String location) {


    public static LibraryDto libraryDto(Library library){
        return new LibraryDto(library.getLibId(), library.getName(), library.getLocation());
    }

    public Library toLibrary(){
        return new Library(libId, name, location);
    }

}
