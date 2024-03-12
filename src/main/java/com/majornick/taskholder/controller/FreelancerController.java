package com.majornick.taskholder.controller;

import com.majornick.taskholder.dto.FreelancerDTO;
import com.majornick.taskholder.service.FreelancerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/freelancers")
public class FreelancerController {
    private final FreelancerService freelancerService;
    @GetMapping
    ResponseEntity<?> getFreelancers() {
        return ResponseEntity.ok(freelancerService.getFreelancers());
    }

    @GetMapping("/{freelancerId}")
    ResponseEntity<?> getFreelancer(@PathVariable long freelancerId) {
        return ResponseEntity.ok(freelancerService.getById(freelancerId));
    }

    @PutMapping("/{freelancerId}")
    ResponseEntity<?> updateFreelancer(@PathVariable long freelancerId, FreelancerDTO freelancerDTO) {
        return ResponseEntity.ok(freelancerService.updateFreelancer(freelancerId,freelancerDTO));
    }

    @PostMapping("/")
    ResponseEntity<?> postFreelancer(FreelancerDTO freelancerDTO) {
        return ResponseEntity.ok(freelancerService.saveFreelancer(freelancerDTO));
    }

    @GetMapping("/{freelancerId}/tasks")
    ResponseEntity<?> getFreelancerHistory(@PathVariable long freelancerId) {
        return ResponseEntity.ok(freelancerService.getFreelancerTaskHistory(freelancerId));
    }


}
