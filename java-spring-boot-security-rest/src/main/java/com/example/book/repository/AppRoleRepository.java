package com.example.book.repository;

import com.example.book.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AppRoleRepository extends JpaRepository<AppRole, Integer> {

    @Query("Select r from AppRole r where r.roleName = ?1")
    Optional<AppRole> findByRoleName(String role);
}
