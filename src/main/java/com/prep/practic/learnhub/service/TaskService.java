package com.prep.practic.learnhub.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskService {

    private final Counter taskCounter;

    @Autowired
    public TaskService(MeterRegistry registry) {
        // create a custom counter metric
        this.taskCounter = Counter.builder("tasks.created")
                .description("Number of tasks created")
                .register(registry);
    }

    public void createTask(String title) {
        // your "business logic"
        System.out.println("Task created: " + title);

        // increment metric
        taskCounter.increment();
    }
}

