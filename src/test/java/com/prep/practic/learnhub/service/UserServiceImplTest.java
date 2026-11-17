package com.prep.practic.learnhub.service;
import com.prep.practic.learnhub.dto.CreateUserRequest;
import com.prep.practic.learnhub.exception.UserAlreadyExistsException;
import com.prep.practic.learnhub.exception.UserNotFoundException;
import com.prep.practic.learnhub.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository repo;

    @Mock
    org.springframework.security.crypto.password.PasswordEncoder encoder;

    @InjectMocks
    UserServiceImpl service;

    @Test
    void testCreateUserSuccess() { /* TODO */ }

    @Test
    void testCreateUserUsernameExists() { /* TODO */ }

    @Test
    void testCreateUserEmailExists() { /* TODO */ }

    @Test
    void testUpdateUserSuccess() { /* TODO */ }

    @Test
    void testUpdateUserNotFound() { /* TODO */ }

    @Test
    void testGetUserSuccess() { /* TODO */ }

    @Test
    void testGetUserNotFound() { /* TODO */ }

    @Test
    void testDeleteUserSuccess() { /* TODO */ }

    @Test
    void testDeleteUserNotFound() { /* TODO */ }
}