package com.majornick.taskholder.controller;

import com.majornick.taskholder.dto.TaskDTO;
import com.majornick.taskholder.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @GetMapping
    ResponseEntity<?> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/{taskId}")
    ResponseEntity<?> getTask(@PathVariable long taskId) {
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }

    @PutMapping("/{taskId}")
    ResponseEntity<?> updateTask(@PathVariable long taskId, TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.updateTask(taskId,taskDTO));
    }



    @PostMapping("/{taskId}/register/{freelancerId}")
    ResponseEntity<?> registerFreelancer(@PathVariable("taskId") long taskId,@PathVariable("freelancerId") long freelancerId, @RequestParam("deadline") LocalDate deadline ){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.registerFreelancerOnTask(taskId,freelancerId,deadline));
    }

}
