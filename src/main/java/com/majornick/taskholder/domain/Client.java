package com.majornick.taskholder.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Entity
@Getter
@Setter
public class Client extends User {
    private Double amountPaid;
    @OneToMany(mappedBy = "assigner")
    private List<Task> assignedTaskHistory;

    @Transactional
    public void updateClient(Client client) {
        if (client.getUsername() != null) {
            setUsername(client.getUsername());
        }
        if (client.getAmountPaid() != null) {
            setAmountPaid(client.getAmountPaid());
        }
    }
}

