package com.grupo10.despensa.service;

import com.grupo10.despensa.entity.Client;
import com.grupo10.despensa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl {

    @Autowired
    private ClientRepository clientRepository;

    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    public void removeClient(Client client) {
        clientRepository.delete(client);
    }

    public Client getById(Integer id) {
        Client client = new Client();
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()) {
            client = clientOptional.get();
        }
        return client;
    }
}
