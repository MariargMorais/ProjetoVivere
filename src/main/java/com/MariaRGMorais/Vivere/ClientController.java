package com.MariaRGMorais.Vivere;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MariaRGMorais.Vivere.entity.Client;
import com.MariaRGMorais.Vivere.exception.ResourceNotFoundException;
import com.MariaRGMorais.Vivere.repository.ClientRepository;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    // get all clients
    @GetMapping
    public List < Client > getAllClients() {
        return this.clientRepository.findAll();
    }

    // get client by id
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable(value = "id") int clientId) {
        return this.clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("Client not found with id :" + clientId));
    }

    // create client
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return this.clientRepository.save(client);
    }

    // update client
    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable("id") int clientId) {
    	Client existingClient = this.clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("Client not found with id :" + clientId));
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        return this.clientRepository.save(existingClient);
    }

    // delete client by id
    @DeleteMapping("/{id}")
    public ResponseEntity < Client > deleteClient(@PathVariable("id") int clientId) {
    	Client existingClient = this.clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("Client not found with id :" + clientId));
        this.clientRepository.delete(existingClient);
        return ResponseEntity.ok().build();
    }
}