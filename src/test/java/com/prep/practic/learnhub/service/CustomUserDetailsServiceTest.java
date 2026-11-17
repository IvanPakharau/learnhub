package com.prep.practic.learnhub.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailsServiceTest {

    @Mock
    com.prep.practic.learnhub.repository.UserRepository repo;

    @InjectMocks
    CustomUserDetailsService service;

    @Test
    void testLoadUserByUsernameSuccess() { /* TODO */ }

    @Test
    void testLoadUserByUsernameNotFound() { /* TODO */ }
}