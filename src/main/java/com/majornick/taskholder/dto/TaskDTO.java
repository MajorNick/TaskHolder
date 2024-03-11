package com.majornick.taskholder.dto;

import com.majornick.taskholder.domain.Task;
import com.majornick.taskholder.enums.TaskState;

public class TaskDTO {
    private final Task task;

    public TaskDTO(Task task) {
        this.task = task;
    }

    public TaskDTO() {
        task = new Task();
    }

    public long getId() {
        return task.getId();
    }

    public String getName() {
        return task.getName();
    }

    public void setName(String n) {
        task.setName(n);
    }

    public String getDescription() {
        return task.getDescription();
    }

    public void setDescription(String n) {
        task.setDescription(n);
    }

    public double getSalary() {
        return task.getSalary();
    }

    public void setSalary(double k) {
        task.setSalary(k);
    }


    public TaskState getState() {
        return task.getState();
    }

    public void setState(TaskState state) {
        task.setState(state);
    }


}
