package dao;

import persintenceConnection.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAOImpl implements ClientDAO{

    private ConnectionDB connectionDB;

    public ClientDAOImpl() {
        this.connectionDB = new ConnectionDB();
    }

    /* Ejemplo *


        private void addPerson(Connection connection, int id, String name, int years) throws SQLException {
            String insert = "INSERT INTO persona (id, nombre, edad) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, years);
            ps.executeUpdate();
            ps.close();
            connection.commit();

        }

         */
    public boolean addClient(int idClient, String name, String email) throws SQLException {
        try {
            Connection connection = connectionDB.getInstance();
            String add = "INSERT INTO client(idClient, name, email) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(add);
            ps.setInt(1, idClient);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.executeUpdate();
            ps.close();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connectionDB.connectionClose();
            return false;
        }
        connectionDB.connectionClose();
        return true;
    }
}
