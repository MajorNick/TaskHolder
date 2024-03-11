package com.majornick.taskholder.controller;

import com.majornick.taskholder.dto.ClientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Clients")
public class ClientController {
    @GetMapping
    ResponseEntity<?> getClients() {
        return ResponseEntity.ok(5);
    }

    @GetMapping("/{clientId}")
    ResponseEntity<?> getClient(@PathVariable long clientId) {
        return ResponseEntity.ok(clientId);
    }

    @PutMapping("/{clientId}")
    ResponseEntity<?> updateClient(@PathVariable long clientId, ClientDTO clientDTO) {
        return ResponseEntity.ok(clientDTO);
    }

    @PostMapping("/")
    ResponseEntity<?> postClient(ClientDTO clientDTO) {
        return ResponseEntity.ok(clientDTO);
    }

    @GetMapping("/{clientId}/tasks")
    ResponseEntity<?> getFreelancerHistory(@PathVariable long clientId) {
        return ResponseEntity.ok(clientId);
    }
}
