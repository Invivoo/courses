package com.example.book.repository;

import com.example.book.model.AppUser;
import com.example.book.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@Import(BookService.class)
public class AppUserRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AppUserRepository appUserRepository;


    @Test
    public void findByUserName() {

        AppUser user = new AppUser(null,"test",
                bCryptPasswordEncoder.encode("user"), null);

        entityManager.persist(user);

        Optional<AppUser> test = appUserRepository.findByUserName("test");

        assertThat(test.isPresent()).isEqualTo(true);
        assertThat(test.get().getUserName()).isEqualTo("test");

    }


}