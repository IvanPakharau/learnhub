package com.prep.practic.learnhub.jwt;

import org.junit.jupiter.api.Test;

class JwtUtilTest {

    JwtUtil jwtUtil = new JwtUtil("testsecret12345678901234567890", 3600000);

    @Test
    void testGenerateToken() { /* TODO */ }

    @Test
    void testGenerateRefreshToken() { /* TODO */ }

    @Test
    void testExtractUsername() { /* TODO */ }

    @Test
    void testValidateToken() { /* TODO */ }
}