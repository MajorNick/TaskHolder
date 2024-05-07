package com.majornick.taskholder.domain;

import com.majornick.taskholder.enums.TaskState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "task_seq", sequenceName = "task_seq")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    private long id;

    private String name;

    private String description;

    private Double salary;
    private LocalDate deadline;

    @Enumerated(value = EnumType.STRING)
    private TaskState state;


    @ManyToOne
    private Freelancer performer;

    @ManyToOne
    private Client assigner;


}
