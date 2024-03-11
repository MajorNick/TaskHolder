package com.majornick.taskholder.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Client extends User{
    private double amountPaid;
    @OneToMany(mappedBy = "assigner")
    private List<Task> assignedTaskHistory;

}
