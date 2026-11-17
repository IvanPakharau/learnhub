package com.prep.practic.learnhub.dto;

import com.prep.practic.learnhub.domain.Role;

import java.time.Instant;

public record UserDto(Long id,
                      String username,
                      String email,
                      String fullName,
                      Instant createdAt,
                      Role role) {}
