package service;

import daoImpl.BillDAOImpl;
import entity.Bill;

import java.sql.SQLException;

public class BillService {

    private BillDAOImpl billDAOImpl;

    public BillService() {
        this.billDAOImpl = new BillDAOImpl();
    }

    public boolean addBill(Bill bill) throws SQLException {
        int idBill = bill.getIdBill();
        int idClient = bill.getIdCliente();
        return billDAOImpl.addBill(idBill, idClient);
    }
}
