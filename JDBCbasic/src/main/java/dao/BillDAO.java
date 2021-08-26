package dao;

import java.sql.SQLException;

public interface BillDAO {
    boolean addBill(int idBill, int idClient) throws SQLException;
}
