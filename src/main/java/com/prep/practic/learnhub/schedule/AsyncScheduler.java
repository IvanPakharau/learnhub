package com.prep.practic.learnhub.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableAsync
@Component
public class AsyncScheduler {

    @Async
    @Scheduled(fixedRate = 5000000)
    public void asyncTask() throws InterruptedException {
        System.out.println("Async task started: " + Thread.currentThread().getName());
        Thread.sleep(3000); // simulate long-running task
        System.out.println("Async task finished: " + Thread.currentThread().getName());
    }
}