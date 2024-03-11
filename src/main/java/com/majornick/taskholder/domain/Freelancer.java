package com.majornick.taskholder.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Freelancer extends User{
    private double amountReceived;
    @OneToMany(mappedBy = "performer")
    private List<Task> taskHistory;


}
