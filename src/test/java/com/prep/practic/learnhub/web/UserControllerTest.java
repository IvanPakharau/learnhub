package com.prep.practic.learnhub.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockitoBean
    com.prep.practic.learnhub.service.UserService svc;

    @Test
    void testCreateUser() { /* TODO */ }

    @Test
    void testGetUser() { /* TODO */ }

    @Test
    void testListUsers() { /* TODO */ }
}