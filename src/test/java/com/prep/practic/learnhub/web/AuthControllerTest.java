package com.prep.practic.learnhub.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @MockitoBean
    org.springframework.security.authentication.AuthenticationManager authManager;

    @MockitoBean
    com.prep.practic.learnhub.jwt.JwtUtil jwtUtil;

    @Test
    void testLoginSuccess() { /* TODO */ }

    @Test
    void testLoginInvalidCredentials() { /* TODO */ }
}