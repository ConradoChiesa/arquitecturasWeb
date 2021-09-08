package dao;

import entity.BestClients;
import entity.ProductMaxProfit;

import java.sql.SQLException;
import java.util.List;

public interface ApiDAO {

    ProductMaxProfit getProductMaxProfit() throws SQLException;

    List<BestClients> getBestClients() throws SQLException;

}
