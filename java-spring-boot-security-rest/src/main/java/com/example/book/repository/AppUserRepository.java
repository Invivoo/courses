package com.example.book.repository;

import com.example.book.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    @Query("Select u from AppUser u join fetch u.roles where u.userName = ?1")
    Optional<AppUser> findByUserName(String useName);
}
