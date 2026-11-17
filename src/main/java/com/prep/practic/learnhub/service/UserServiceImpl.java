package com.prep.practic.learnhub.service;


import com.prep.practic.learnhub.dto.*;
import com.prep.practic.learnhub.domain.User;
import com.prep.practic.learnhub.exception.UserAlreadyExistsException;
import com.prep.practic.learnhub.exception.UserNotFoundException;
import com.prep.practic.learnhub.repository.UserRepository;
import org.springframework.data.domain.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo; this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDto createUser(CreateUserRequest req) {
        // simple checks
        if (repo.findByUsername(req.getUsername()).isPresent())
            throw new UserAlreadyExistsException("username_exists");
        if (repo.findByEmail(req.getEmail()).isPresent())
            throw new UserAlreadyExistsException("email_exists");

        User u = new User();
        u.setUsername(req.getUsername());
        u.setEmail(req.getEmail());
        u.setFullName(req.getFullName());
        u.setPassword(passwordEncoder.encode(req.getPassword()));

        User saved = repo.save(u);
        return toDto(saved);
    }

    @Override
    public UserDto getUser(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public Page<UserDto> listUsers(Pageable pageable) {
        return repo.findAll(pageable).map(this::toDto);
    }

    @Override
    public void deleteUser(Long id) {
        if (!repo.existsById(id)) {
            throw new UserNotFoundException("Cannot delete: user does not exist");
        }
        repo.deleteById(id);
    }

    @Override
    public UserDto updateUser(Long id, CreateUserRequest req) {
        User u = repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Cannot update: user does not exist"));

        // Check uniqueness if username/email changed
        repo.findByUsername(req.getUsername())
                .filter(existing -> !existing.getId().equals(id))
                .ifPresent(existing -> {
                    throw new UserAlreadyExistsException("username_exists");
                });

        repo.findByEmail(req.getEmail())
                .filter(existing -> !existing.getId().equals(id))
                .ifPresent(existing -> {
                    throw new UserAlreadyExistsException("email_exists");
                });

        // Update fields
        u.setUsername(req.getUsername());
        u.setEmail(req.getEmail());
        u.setFullName(req.getFullName());

        if (req.getPassword() != null && !req.getPassword().isBlank()) {
            u.setPassword(passwordEncoder.encode(req.getPassword()));
        }

        return toDto(repo.save(u));
    }

    private UserDto toDto(User user){
        return new UserDto(
                user.getId(), user.getUsername(), user.getEmail(),
                user.getFullName(), user.getCreatedAt(), user.getRole()
        );
    }
}