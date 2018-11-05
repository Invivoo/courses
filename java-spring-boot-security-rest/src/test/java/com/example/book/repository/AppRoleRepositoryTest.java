package com.example.book.repository;

import com.example.book.model.AppRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest

public class AppRoleRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private AppRoleRepository appRoleRepository;

    @Test
    public void findByRoleName() {
        AppRole role = new AppRole(null,"admin-test");

        entityManager.persist(role);

        Optional<AppRole> test = appRoleRepository.findByRoleName("admin-test");

        assertThat(test.isPresent()).isEqualTo(true);
        assertThat(test.get().getRoleName()).isEqualTo("admin-test");
    }
}