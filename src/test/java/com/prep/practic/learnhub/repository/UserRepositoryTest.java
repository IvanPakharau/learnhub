package com.prep.practic.learnhub.repository;

import com.prep.practic.learnhub.domain.Role;
import com.prep.practic.learnhub.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository repo;

    @Test
    void findByUsername() {
        User user = new User();
        user.setUsername("john");
        user.setEmail("john@example.com");
        user.setPassword("pass");
        user.setRole(Role.USER);
        repo.save(user);

        Optional<User> found = repo.findByUsername("john");
        assertThat(found).isPresent();
        assertThat(found.get().getEmail()).isEqualTo("john@example.com");
    }

    @Test
    void findByEmail() {
    }

    @Test
    void testSaveAndDelete() {

    }
}