package com.example.demo.controllers;


import com.example.demo.entities.Client;
import com.example.demo.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class ClientController {
     private final  ClientService clientService ;
    private final static Logger logger = Logger.getLogger(String.valueOf(ClientController.class));

    @GetMapping("clients")
    @PreAuthorize("hasAuthority('admin:read')")
    public List<Client> getAllClients() {
        logger.info("getAllClients");
        return clientService.getAllClients();
    }

    @GetMapping("client/{id}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        logger.info("getClientById");
        Optional<Client> client = clientService.getClientById(id);
        if (client.isPresent()) {
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("client")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        logger.info("Adding client");
        Client addedClient = clientService.addClient(client);
        return new ResponseEntity<>(addedClient, HttpStatus.CREATED);
    }

    @DeleteMapping("client/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        logger.info("Removing client");
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("client/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        logger.info("updating client");
        Client updatedClient = clientService.updateClient(id, client);
        if (updatedClient != null) {
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}