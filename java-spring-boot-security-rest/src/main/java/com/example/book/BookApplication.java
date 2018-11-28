package com.example.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
        //User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return  () -> Optional.of("admin");
    }
    @Bean
    public BCryptPasswordEncoder cryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
