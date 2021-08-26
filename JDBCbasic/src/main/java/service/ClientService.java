package service;

import daoImpl.ClientDAOImpl;
import entity.Client;

import java.sql.SQLException;

public class ClientService {

    private ClientDAOImpl clientDAOImpl;

    public ClientService() {
        this.clientDAOImpl = new ClientDAOImpl();
    }

    public boolean addClient(Client client) throws SQLException {
        int idClient = client.getIdClient();
        String name = client.getName();
        String email = client.getEmail();
        return clientDAOImpl.addClient(idClient, name, email);
    }
}
