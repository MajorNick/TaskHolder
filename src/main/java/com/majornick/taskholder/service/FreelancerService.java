package com.majornick.taskholder.service;

import com.majornick.taskholder.repository.FreelancerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FreelancerService {
    private final FreelancerRepo freelancerRepo;
}
