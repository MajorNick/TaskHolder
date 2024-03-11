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
        return getDateOfRegister();
    }

    public void setDateOfRegister(LocalDate dateOfRegister) {
        setDateOfRegister(dateOfRegister);
    }

    public double getAmountPaid() {
        return client.getAmountPaid();
    }

    public void setAmountPaid(double amountPaid) {
        client.setAmountPaid(amountPaid);
    }
}
