package daoImpl;

import dao.BillDAO;
import persintenceConnection.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillDAOImpl implements BillDAO {

    private ConnectionDB connectionDB;

    public BillDAOImpl() {
        this.connectionDB = new ConnectionDB();
    }

    @Override
    public boolean addBill(int idBill, int idClient) throws SQLException {
        try {
            Connection connection = connectionDB.getInstance();
            String add = "INSERT INTO bill(idBill, idClient) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(add);
            ps.setInt(1, idBill);
            ps.setInt(2, idClient);
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
