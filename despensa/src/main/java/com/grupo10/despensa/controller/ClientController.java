package com.grupo10.despensa.controller;

import com.grupo10.despensa.entity.Product;
import com.grupo10.despensa.service.ClientServiceImpl;
import com.grupo10.despensa.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping(path = "/add")
    public void addNewUser(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @GetMapping(path="/getAll")
    public @ResponseBody
    Iterable<Client> getAllUsers() { return clientService.getAllClients(); }

    @GetMapping("/getById")
    public Client getClientById(@RequestParam Integer id){
        return clientService.getById(id);
    }

    @PutMapping("/update")
    public Client updateClient(Client client) {
        return clientService.updateClient(client);
    }

    @DeleteMapping("/remove")
    public void remove(Client client){
        clientService.removeClient(client);
    }

    @PostMapping("/buy")
    public Product buyProduct(Product product, Client client) throws Exception {
        return clientService.buyProduct(product, client);
    }

}