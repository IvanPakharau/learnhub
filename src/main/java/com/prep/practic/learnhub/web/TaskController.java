package com.prep.practic.learnhub.web;

import com.prep.practic.learnhub.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/{title}")
    public String create(@PathVariable String title) {
        service.createTask(title);
        return "Task created: " + title;
    }
}
