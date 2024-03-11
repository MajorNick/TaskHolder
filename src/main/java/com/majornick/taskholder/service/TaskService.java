package com.majornick.taskholder.service;

import com.majornick.taskholder.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepo taskRepo;
}
