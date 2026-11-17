package com.prep.practic.learnhub.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(AdminUserController.class)
class AdminUserControllerTest {

    @MockitoBean
    com.prep.practic.learnhub.service.UserService userService;

    @Test
    void testListUsers() { /* TODO */ }

    @Test
    void testCreateUserForm() { /* TODO */ }

    @Test
    void testEditUserForm() { /* TODO */ }

    @Test
    void testDeleteUser() { /* TODO */ }
}