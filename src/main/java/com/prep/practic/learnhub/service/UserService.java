package com.prep.practic.learnhub.service;

import com.prep.practic.learnhub.dto.CreateUserRequest;
import com.prep.practic.learnhub.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDto createUser(CreateUserRequest req);
    UserDto getUser(Long id);
    Page<UserDto> listUsers(Pageable pageable);
    void deleteUser(Long id);
    UserDto updateUser(Long id, CreateUserRequest req);
}