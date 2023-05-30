package com.example.demo.services;

import com.example.demo.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getAllClients();
    Optional<Client> getClientById(Long id);
    Client addClient(Client client);
    void deleteClient(Long id);
    Client updateClient(Long id, Client client);
}
