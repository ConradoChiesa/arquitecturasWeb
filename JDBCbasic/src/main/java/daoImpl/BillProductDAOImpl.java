package daoImpl;

import dao.BillProductDAO;
import persintenceConnection.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillProductDAOImpl implements BillProductDAO {

    /* Constructor */
    public BillProductDAOImpl() {
    }

    @Override
    public boolean addBillProduct(int idBill, int idProduct, int quantity) throws SQLException {
        try {
            Connection connection = ConnectionDB.getInstance();
            String add = "INSERT INTO billProduct(idBill, idProduct, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(add);
            ps.setInt(1, idBill);
            ps.setInt(2, idProduct);
            ps.setInt(3, quantity);
            ps.executeUpdate();
            ps.close();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
