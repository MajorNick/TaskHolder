package com.majornick.taskholder.service;

import com.majornick.taskholder.domain.Task;
import com.majornick.taskholder.dto.TaskDTO;
import com.majornick.taskholder.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepo taskRepo;

    @Transactional
    public List<TaskDTO> getTasks() {
        return taskRepo.findAll().stream().map(TaskDTO::new).toList();
    }

    public TaskDTO getTaskById(long taskId) {
        return new TaskDTO(
                taskRepo
                .findById(taskId)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "task not found")));
    }

    @Transactional
    public TaskDTO updateTask(long taskId, TaskDTO taskDTO) {
        Task task = getTaskById(taskId).toTask();
        task.update(taskDTO);
        return new TaskDTO(task);
    }

    @Transactional
    public TaskDTO postTask(TaskDTO taskDTO) {
        return new TaskDTO(taskRepo.save(taskDTO.toTask()));
    }
}
