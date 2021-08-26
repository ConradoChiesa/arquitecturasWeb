package controller;

import entity.Client;
import service.ClientService;

import java.sql.SQLException;

public class ClientController {

    private ClientService clientService;

    public ClientController() {
        this.clientService = new ClientService();
    }

    public boolean addClient(Client client) throws Exception {
        return clientService.addClient(client);
    }
}
