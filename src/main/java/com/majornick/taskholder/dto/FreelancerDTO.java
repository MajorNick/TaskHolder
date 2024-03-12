package com.majornick.taskholder.dto;

import com.majornick.taskholder.domain.Freelancer;

import java.time.LocalDate;

public class FreelancerDTO {
    private final Freelancer freelancer;

    public FreelancerDTO(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    public FreelancerDTO() {
        freelancer = new Freelancer();
    }
    public Freelancer toFreelancer(){
        return freelancer;
    }

    public long getId() {
        return freelancer.getId();
    }

    public LocalDate getDateOfRegister() {
        return freelancer.getDateOfRegister();
    }

    public void setDateOfRegister(LocalDate dateOfRegister) {
        freelancer.setDateOfRegister(dateOfRegister);
    }

    public Double getAmountReceived() {
        return freelancer.getAmountReceived();
    }

    public void setAmountReceived(Double amountReceived) {
        freelancer.setAmountReceived(amountReceived);
    }
}
