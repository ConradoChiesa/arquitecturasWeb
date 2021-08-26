package service;

import daoImpl.BillProductDAOImpl;
import entity.BillProduct;

import java.sql.SQLException;

public class BillProductService {

    private BillProductDAOImpl billProductDAOImpl;

    /* Constructor */
    public BillProductService() {
        this.billProductDAOImpl = new BillProductDAOImpl();
    }

    public boolean addBillProduct(BillProduct billProduct) throws SQLException {
        int idBill = billProduct.getIdBill();
        int idProduct = billProduct.getIdProduct();
        int quantity = billProduct.getQuantity();
        return billProductDAOImpl.addBillProduct(idBill, idProduct, quantity);
    }


}
