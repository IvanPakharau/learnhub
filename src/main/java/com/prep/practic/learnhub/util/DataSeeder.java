package com.prep.practic.learnhub.util;

import com.prep.practic.learnhub.domain.Role;
import com.prep.practic.learnhub.domain.User;
import com.prep.practic.learnhub.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public DataSeeder(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {
        if (repo.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setFullName("admin");
            admin.setEmail("admin@example.com");
            admin.setPassword(encoder.encode("123"));
            admin.setRole(Role.ADMIN);
            repo.save(admin);
            System.out.println("Seeded initial admin user 'admin'");
        }
    }
}
