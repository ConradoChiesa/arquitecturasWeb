package dao;

import entity.Product;

import java.sql.SQLException;

public interface ProductDAO {

    boolean addProduct(int idProduct, String name, float amount) throws Exception;

}
