package com.prep.practic.learnhub.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoScheduler {

    // Run every 10 seconds
    @Scheduled(fixedRate = 10000000)
    public void logTime() {
        System.out.println("Task executed at: " + java.time.LocalDateTime.now());
    }

    // Run at a cron schedule (every minute)
    @Scheduled(cron = "0 * * * * *")
    public void cronTask() {
        System.out.println("Cron task executed at: " + java.time.LocalDateTime.now());
    }
}