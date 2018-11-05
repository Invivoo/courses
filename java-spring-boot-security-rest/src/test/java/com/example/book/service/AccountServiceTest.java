package com.example.book.service;

import com.example.book.model.AppRole;
import com.example.book.model.AppUser;
import com.example.book.repository.AppRoleRepository;
import com.example.book.repository.AppUserRepository;
import com.sun.tools.javac.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest

public class AccountServiceTest {


    @MockBean
    private AppUserRepository userRepositoryMock;

    @MockBean
    private AppRoleRepository roleRepositoryMock;

    @Autowired
    private AccountService accountService;


    @Test
    public void addRoleToUser() {
        AppUser user = initUser();
        given(userRepositoryMock.findByUserName("admin")).willReturn(Optional.of(user));
        given(roleRepositoryMock.findByRoleName("ADMIN")).willReturn(Optional.of(initRole()));

        accountService.addRoleToUser("admin", "ADMIN");
        assertThat(user.getRoles().size()).isEqualTo(1);

    }


    private AppUser initUser() {

        return new AppUser(1, "admin", "124", new ArrayList<>());
    }

    private AppRole initRole() {

        return new AppRole(1, "ADMIN");
    }
}