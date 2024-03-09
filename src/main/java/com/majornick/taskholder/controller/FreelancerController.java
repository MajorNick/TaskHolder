package com.majornick.taskholder.controller;

import com.majornick.taskholder.dto.FreelancerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/freelancers")
public class FreelancerController {

    @GetMapping
    ResponseEntity<?> getFreelancers(){
        return ResponseEntity.ok(5);
    }
    @GetMapping("/{freelancerId}")
    ResponseEntity<?> getFreelancer(@PathVariable long freelancerId){
        return ResponseEntity.ok(freelancerId);
    }
    @PutMapping("/{freelancerId}")
    ResponseEntity<?> updateFreelancer(@PathVariable long freelancerId, FreelancerDTO freelancerDTO){
        return ResponseEntity.ok(freelancerId);
    }

    @PostMapping("/")
    ResponseEntity<?> postFreelancer(FreelancerDTO freelancerDTO){
        return ResponseEntity.ok(freelancerDTO);
    }


}
