package com.majornick.taskholder.controller;

import com.majornick.taskholder.dto.ClientDTO;
import com.majornick.taskholder.dto.TaskDTO;
import com.majornick.taskholder.service.ClientService;
import com.majornick.taskholder.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    ResponseEntity<?> getClients() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @GetMapping("/{clientId}")
    ResponseEntity<?> getClient(@PathVariable long clientId) {
        return ResponseEntity.ok(clientService.getById(clientId));
    }

    @PutMapping("/{clientId}")
    ResponseEntity<?> updateClient(@PathVariable long clientId, ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.updateClient(clientId, clientDTO));
    }

    @PostMapping("/")
    ResponseEntity<?> postClient(ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.saveClient(clientDTO));
    }

    @GetMapping("/{clientId}/tasks")
    ResponseEntity<?> getClientHistory(@PathVariable long clientId) {
        return ResponseEntity.ok(clientService.getClientHistory(clientId));
    }

    @PostMapping("/{clientId}/tasks")
    ResponseEntity<?> postTask(TaskDTO taskDTO,@PathVariable("clientId") long clientId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.postTask(taskDTO,clientId));
    }

}
