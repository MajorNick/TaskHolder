package com.majornick.taskholder.service;

import com.majornick.taskholder.domain.Client;
import com.majornick.taskholder.domain.Task;
import com.majornick.taskholder.dto.ClientDTO;
import com.majornick.taskholder.dto.TaskDTO;
import com.majornick.taskholder.repository.ClientRepo;
import com.majornick.taskholder.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepo clientRepo;
    private final TaskRepo taskRepo;

    @Transactional(readOnly = true)
    public List<ClientDTO> getClients() {
        return clientRepo.findAll().stream().map(ClientDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ClientDTO getById(long clientId) {
        return new ClientDTO(clientRepo
                .findById(clientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "client not found"))
        );
    }

    @Transactional
    public ClientDTO updateClient(long clientId, ClientDTO clientDTO) {
        Client client = getById(clientId).toClient();
        client.updateClient(clientDTO.toClient());
        return new ClientDTO(client);
    }
    @Transactional
    public TaskDTO postTask(TaskDTO taskDTO,long clientId) {
        Task task = taskDTO.toTask();
        Client client = getById(clientId).toClient();
        task.setAssigner(client);
        return new TaskDTO(taskRepo.save(task));
    }

    @Transactional
    public ClientDTO saveClient(ClientDTO clientDTO) {
        return new ClientDTO(clientRepo.save(clientDTO.toClient()));
    }

    @Transactional(readOnly = true)
    public List<TaskDTO> getClientHistory(long clientId) {
        Client client = getById(clientId).toClient();
        return client
                .getAssignedTaskHistory()
                .stream()
                .map(TaskDTO::new)
                .toList();
    }
}
