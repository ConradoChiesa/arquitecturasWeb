package controller;

import entity.BillProduct;
import service.BillProductService;

import java.sql.SQLException;

public class BillProductController {

    private BillProductService billProductService;

    /* Constructor */
    public BillProductController() {
        this.billProductService = new BillProductService();
    }

    public boolean addBillProduct(BillProduct billProduct) throws SQLException {
        return billProductService.addBillProduct(billProduct);
    }
}
