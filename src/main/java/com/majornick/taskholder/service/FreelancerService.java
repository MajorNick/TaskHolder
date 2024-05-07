package com.majornick.taskholder.service;

import com.majornick.taskholder.domain.Freelancer;
import com.majornick.taskholder.dto.FreelancerDTO;
import com.majornick.taskholder.dto.TaskDTO;
import com.majornick.taskholder.repository.FreelancerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreelancerService {
    private final FreelancerRepo freelancerRepo;

    @Transactional(readOnly = true)
    public List<FreelancerDTO> getFreelancers() {
        return freelancerRepo.findAll().stream().map(FreelancerDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public FreelancerDTO getById(long freelancerId) {
        return new FreelancerDTO(freelancerRepo
                .findById(freelancerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "freelancer not found"))
        );
    }

    @Transactional
    public FreelancerDTO updateFreelancer(long freelancerId, FreelancerDTO freelancerDTO) {
        Freelancer freelancer = getById(freelancerId).toFreelancer();
        updateFreelancer(freelancer, freelancerDTO.toFreelancer());
        return new FreelancerDTO(freelancer);
    }

    @Transactional
    public void updateFreelancer(Freelancer actualFreelancer, Freelancer freelancer) {
        if (freelancer.getUsername() != null) {
            actualFreelancer.setUsername(freelancer.getUsername());
        }
        if (freelancer.getAmountReceived() != null) {
            actualFreelancer.setAmountReceived(freelancer.getAmountReceived());
        }
    }

    @Transactional
    public FreelancerDTO saveFreelancer(FreelancerDTO freelancerDTO) {
        return new FreelancerDTO(freelancerRepo.save(freelancerDTO.toFreelancer()));
    }

    @Transactional(readOnly = true)
    public List<TaskDTO> getFreelancerTaskHistory(long freelancerId) {
        Freelancer freelancer = getById(freelancerId).toFreelancer();
        return freelancer
                .getTaskHistory()
                .stream()
                .map(TaskDTO::new)
                .toList();
    }
}
