package com.prep.practic.learnhub.web;

import com.prep.practic.learnhub.dto.*;
import com.prep.practic.learnhub.service.UserService;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService svc;

    public UserController(UserService svc){ this.svc = svc; }

    @PostMapping
    public ResponseEntity<UserDto> create(@Validated @RequestBody CreateUserRequest req){
        UserDto created = svc.createUser(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable Long id){
        return ResponseEntity.ok(svc.getUser(id));
    }

    @GetMapping
    public ResponseEntity<Page<UserDto>> list(Pageable pageable){
        return ResponseEntity.ok(svc.listUsers(pageable));
    }
}