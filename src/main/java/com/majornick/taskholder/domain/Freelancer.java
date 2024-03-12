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
    private Double amountReceived;
    @OneToMany(mappedBy = "performer")
    private List<Task> taskHistory;

    public void updateFreelancer(Freelancer freelancer) {
        if (freelancer.getUsername() != null) {
            setUsername(freelancer.getUsername());
        }
        if (freelancer.getAmountReceived() != null) {
            setAmountReceived(freelancer.getAmountReceived());
        }
    }
}
