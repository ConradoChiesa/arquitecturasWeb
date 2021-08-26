package dao;

import java.sql.SQLException;

public interface ClientDAO {

    boolean addClient(int idClient, String name, String email) throws SQLException;

}
