package service;

import daoImpl.ClientDAOImpl;
import entity.Client;

import java.sql.SQLException;

public class ClientService {

    private ClientDAOImpl clientDAOImpl;

    public ClientService() {
        this.clientDAOImpl = new ClientDAOImpl();
    }

    public ClientService(ClientDAOImpl clientDAOImpl) {
        this.clientDAOImpl = clientDAOImpl;
    }

    public boolean addClient(Client client) throws Exception {
        int idClient = client.getIdClient();
        String name = client.getName();
        String email = client.getEmail();
        return clientDAOImpl.addClient(idClient, name, email);
    }
}
