package com.example.book.service;

import com.example.book.model.AppUser;
import com.example.book.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;



    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach(p -> authorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return p.getRoleName();
            }
        }));
        return new User(appUser.getUserName(), appUser.getPassword(), authorities);
    }
}
