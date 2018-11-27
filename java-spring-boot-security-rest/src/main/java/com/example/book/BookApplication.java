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
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaAuditing
public class BookApplication {


    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Bean
    AuditorAware auditor() {
       return  () -> Optional.of("admin");
    }
    @Bean
    public BCryptPasswordEncoder cryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
