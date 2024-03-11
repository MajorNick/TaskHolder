package com.majornick.taskholder.controller;

import com.majornick.taskholder.dto.TaskDTO;
import com.majornick.taskholder.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @GetMapping
    ResponseEntity<?> getTasks() {
        return ResponseEntity.ok(5);
    }

    @GetMapping("/{taskId}")
    ResponseEntity<?> getTask(@PathVariable long taskId) {
        return ResponseEntity.ok(taskId);
    }

    @PutMapping("/{taskId}")
    ResponseEntity<?> updateTask(@PathVariable long taskId, TaskDTO taskDTO) {
        return ResponseEntity.ok(taskDTO);
    }

    @PostMapping("/")
    ResponseEntity<?> postTask(TaskDTO taskDTO) {
        return ResponseEntity.ok(taskDTO);
    }

}
