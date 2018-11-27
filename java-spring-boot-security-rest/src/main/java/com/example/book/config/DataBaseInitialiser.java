package com.example.book.config;

import com.example.book.model.AppRole;
import com.example.book.model.AppUser;
import com.example.book.model.Book;
import com.example.book.repository.AppRoleRepository;
import com.example.book.repository.AppUserRepository;
import com.example.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataBaseInitialiser implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(String... args) throws Exception {

        List.of("T1", "T2", "T3").forEach(t -> bookRepository.save(new Book(null, t)));

        AppRole roleAdmin = appRoleRepository.save(new AppRole(null, "ROLE_ADMIN"));
        AppRole roleUser = appRoleRepository.save(new AppRole(null, "ROLE_USER"));


        if (roleAdmin != null) {
            AppUser admin = appUserRepository.save(new AppUser(null, "admin",
                    bCryptPasswordEncoder.encode("1234"), List.of(roleAdmin)));

        }

        if (roleUser != null) {
            AppUser user = appUserRepository.save(new AppUser(null, "user",
                    bCryptPasswordEncoder.encode("1234"), List.of(roleUser)));
        }

    }
}
