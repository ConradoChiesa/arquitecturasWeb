package controller;

import entity.Bill;
import service.BillService;

import java.sql.SQLException;

public class BillController {

    private BillService billService;

    public BillController() {
        this.billService = new BillService();
    }

    public boolean addBill(Bill bill) throws SQLException {
        return billService.addBill(bill);
    }
}
