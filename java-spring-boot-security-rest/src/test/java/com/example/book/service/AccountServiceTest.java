package com.example.book.service;

import com.example.book.model.AppRole;
import com.example.book.model.AppUser;
import com.example.book.repository.AppRoleRepository;
import com.example.book.repository.AppUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class AccountServiceTest {


    @MockBean
    private AppUserRepository userRepositoryMock;

    @MockBean
    private AppRoleRepository roleRepositoryMock;

    private AccountService accountService;

    @Before
    public void init() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        accountService = new AccountService(bCryptPasswordEncoder, userRepositoryMock, roleRepositoryMock);
    }


    @Test
    public void addRoleToUser() {
        AppUser user = initUser();
        given(userRepositoryMock.findByUserName("admin")).willReturn(Optional.of(user));
        given(roleRepositoryMock.findByRoleName("ADMIN")).willReturn(Optional.of(initRole()));

        accountService.addRoleToUser("admin", "ADMIN");
        assertThat(user.getRoles().size()).isEqualTo(1);
        verify(userRepositoryMock, times(1)).findByUserName("admin");
        verify(roleRepositoryMock, times(1)).findByRoleName("ADMIN");
    }


    private AppUser initUser() {

        return new AppUser(1, "admin", "124", new ArrayList<>());
    }

    private AppRole initRole() {

        return new AppRole(1, "ADMIN");
    }
}