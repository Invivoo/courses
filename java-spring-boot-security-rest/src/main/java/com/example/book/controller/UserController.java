package com.example.book.controller;

import com.example.book.model.AppUser;
import com.example.book.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser user) {

        return ResponseEntity.ok(accountService.saveUser(user));

    }
}
