package com.prep.practic.learnhub.jwt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ExtendWith(MockitoExtension.class)
class JwtFilterTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    FilterChain chain;

    @Mock
    org.springframework.security.core.userdetails.UserDetailsService userDetailsService;

    JwtFilter filter;

    @BeforeEach
    void setup() {
        filter = new JwtFilter(new JwtUtil("testsecret12345678901234567890", 3600000),
                userDetailsService);
    }

    @Test
    void testValidTokenSetsAuth() { /* TODO */ }

    @Test
    void testMissingOrInvalidToken() { /* TODO */ }
}