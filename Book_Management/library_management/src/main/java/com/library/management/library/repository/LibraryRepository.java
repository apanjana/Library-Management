package com.library.management.library.repository;

import com.library.management.library.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Long> {

    Optional<Library> findByPincode(String pincode);

    Optional<Library> findByName(String name);

}
