package com.majornick.taskholder.dto;

import com.majornick.taskholder.domain.Freelancer;

public class FreelancerDTO {
    private final Freelancer freelancer;

    public FreelancerDTO(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    public FreelancerDTO() {
        freelancer = new Freelancer();
    }

    public long getId(){
        return freelancer.getId();
    }
}
