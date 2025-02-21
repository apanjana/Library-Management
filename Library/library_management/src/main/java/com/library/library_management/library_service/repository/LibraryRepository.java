package com.library.library_management.library_service.repository;

import com.library.library_management.library_service.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Long> {

    Optional<Library> findByLocation(String location);

}
