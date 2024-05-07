package com.majornick.taskholder.service;

import com.majornick.taskholder.domain.Freelancer;
import com.majornick.taskholder.domain.Task;
import com.majornick.taskholder.dto.TaskDTO;
import com.majornick.taskholder.enums.TaskState;
import com.majornick.taskholder.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepo taskRepo;
    private final FreelancerService freelancerService;

    @Transactional
    public List<TaskDTO> getTasks() {
        return taskRepo.findAll().stream().map(TaskDTO::new).toList();
    }

    public TaskDTO getTaskById(long taskId) {
        return new TaskDTO(
                taskRepo
                        .findById(taskId)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "task not found")));
    }

    @Transactional
    public TaskDTO updateTask(long taskId, TaskDTO taskDTO) {
        Task task = getTaskById(taskId).toTask();
        update(task, taskDTO);
        return new TaskDTO(task);
    }

    @Transactional
    public void update(Task actualTask, TaskDTO taskDTO) {
        var task = taskDTO.toTask();
        if (task.getName() != null) {
            actualTask.setName(task.getName());
        }
        if (task.getDescription() != null) {
            actualTask.setDescription(task.getDescription());
        }
        if (task.getSalary() != null) {
            actualTask.setSalary(task.getSalary());
        }
        if (task.getState() != null) {
            actualTask.setState(task.getState());
        }
    }

    @Transactional
    public TaskDTO registerFreelancerOnTask(long taskId, long freelancerId, LocalDate deadline) {
        Task task = getTaskById(taskId).toTask();
        Freelancer freelancer = freelancerService.getById(freelancerId).toFreelancer();
        task.setPerformer(freelancer);
        task.setDeadline(deadline);
        task.setState(TaskState.RUNNING);
        return new TaskDTO(task);
    }

}
