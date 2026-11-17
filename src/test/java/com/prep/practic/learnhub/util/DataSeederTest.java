package com.prep.practic.learnhub.util;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class DataSeederTest {

    @Mock
    com.prep.practic.learnhub.repository.UserRepository repo;

    @Mock
    org.springframework.security.crypto.password.PasswordEncoder encoder;

    @InjectMocks
    DataSeeder seeder;

    @Test
    void testSeedAdminUser() { /* TODO */ }
}