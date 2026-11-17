package com.prep.practic.learnhub.dto;

import jakarta.validation.constraints.*;

public class CreateUserRequest {
    @NotBlank @Size(min=3, max=50)
    private String username;

    @NotBlank @Email
    private String email;

    @NotBlank @Size(min=8)
    private String password;

    private String fullName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}