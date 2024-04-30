package com.majornick.taskholder.dto;

import com.majornick.taskholder.domain.Client;

import java.time.LocalDate;

public class ClientDTO {
    private final Client client;

    public ClientDTO(Client client) {
        this.client = client;
    }

    public ClientDTO() {
        this(new Client());
    }

    public Client toClient() {
        return client;
    }

    public long getId() {
        return client.getId();
    }


    public String getUsername() {
        return client.getUsername();
    }

    public void setUsername(String username) {
        client.setUsername(username);
    }

    public LocalDate getDateOfRegister() {
        return client.getDateOfRegister();
    }

    public void setDateOfRegister(LocalDate dateOfRegister) {
        client.setDateOfRegister(dateOfRegister);
    }

    public Double getAmountPaid() {
        return client.getAmountPaid();
    }

    public void setAmountPaid(Double amountPaid) {
        client.setAmountPaid(amountPaid);
    }

}
