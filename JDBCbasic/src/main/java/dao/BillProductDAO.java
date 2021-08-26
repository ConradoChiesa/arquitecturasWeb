package dao;

import java.sql.SQLException;

public interface BillProductDAO {
    boolean addBillProduct(int idBillProduct, int idProduct, int quantity) throws SQLException;
}
