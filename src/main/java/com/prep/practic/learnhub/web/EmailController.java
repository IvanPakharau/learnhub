package com.prep.practic.learnhub.web;

import com.prep.practic.learnhub.email.AsyncEmailService;
import com.prep.practic.learnhub.email.EmailService;
import com.prep.practic.learnhub.jwt.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/mail")
public class EmailController {

    private final EmailService emailService;
    private final AsyncEmailService asyncEmailService;

    public EmailController(EmailService emailService, AsyncEmailService asyncEmailService) {
        this.emailService = emailService;
        this.asyncEmailService = asyncEmailService;
    }

    @GetMapping
    public ResponseEntity<String> sendEmail() {
        try {
            emailService.sendEmail("pakharau.ivan@gmail.com", "Test learnhub", "yo!");
            return ResponseEntity.ok("email sent");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("wtf?");
        }
    }

    @GetMapping("/async")
    public ResponseEntity<String> asyncSendEmail() {
        try {
            asyncEmailService.sendEmail("pakharau.ivan@gmail.com", "Test learnhub async", "yo!");
            return ResponseEntity.ok("email sent async");
        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("wtf?");
        }
    }
}
