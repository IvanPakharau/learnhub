package com.prep.practic.learnhub.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@EnableAsync
@Service
public class AsyncEmailService extends EmailService {

    public AsyncEmailService(JavaMailSender mailSender) {
        super(mailSender);
    }

    @Async
    @Override
    public void sendEmail(String to, String subject, String body) {
        super.sendEmail(to, subject, body);
    }
}
