package com.library.management.library.dto;

import com.library.management.library.domain.Library;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LibraryDto(

        @NotNull(message = "Library ID must not be null")
        long libId,

        @NotNull(message = "Library must have a name")
        @Size(min = 3, message = "Library name must be at least 3 characters long")
        String name,

        @NotNull(message = "Library pincode cannot be null")
        @Size(min = 2, message = "Library name must be at least 2 characters long")
        String pincode,

        @NotNull(message = "City must have a name")
        @Size(min = 3, message = "City name must be at least 3 characters long")
        String city

//        List<BookDto> book
){


    public static LibraryDto libraryDto(Library library){
        return new LibraryDto(library.getLibId(), library.getName(), library.getPincode(), library.getCity());
    }

//    public Library toLibrary(){
//        return new Library(libId, name, pincode);
//    }

}
