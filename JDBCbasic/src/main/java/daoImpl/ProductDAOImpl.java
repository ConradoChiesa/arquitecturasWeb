package daoImpl;

import dao.ProductDAO;
import persintenceConnection.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAOImpl implements AutoCloseable, ProductDAO {

    public ProductDAOImpl() {
    }

    @Override
    public boolean addProduct(int idProduct, String name, float amount) throws Exception {
        try {
            Connection connection = ConnectionDB.getInstance();
            String add = "INSERT INTO product(idProduct, name, amount) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(add);
            ps.setInt(1, idProduct);
            ps.setString(2, name);
            ps.setFloat(3, amount);
            ps.executeUpdate();
            ps.close();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void close() throws Exception {

    }
}
