package com.example.book;

import com.example.book.model.AppRole;
import com.example.book.model.AppUser;
import com.example.book.model.Book;
import com.example.book.repository.AppRoleRepository;
import com.example.book.repository.AppUserRepository;
import com.example.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
@EnableWebSecurity
public class BookApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder cryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {

        List.of("T1", "T2","T3").forEach(t -> bookRepository.save(new Book(null, t)));

        AppRole roleAdmin = appRoleRepository.save(new AppRole(null, "ROLE_ADMIN"));
        AppRole roleUser = appRoleRepository.save(new AppRole(null, "ROLE_USER"));

        AppUser admin = appUserRepository.save(new AppUser(null, "admin",
                bCryptPasswordEncoder.encode("1234"), List.of(roleAdmin)));

        AppUser user = appUserRepository.save(new AppUser(null, "user",
                bCryptPasswordEncoder.encode("1234"), List.of(roleUser)));

    }
}
