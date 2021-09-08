package service;

import daoImpl.ApiDAOImpl;
import entity.BestClients;
import entity.Client;
import entity.ProductMaxProfit;

import java.sql.SQLException;
import java.util.List;

public class ApiService {

    private ApiDAOImpl apiDAOImpl;

    public ApiService() {
        this.apiDAOImpl = new ApiDAOImpl();
    }

    public ProductMaxProfit getProductMaxProfit() throws SQLException {
        return apiDAOImpl.getProductMaxProfit();
    }

    public List<BestClients> getBestClients() throws SQLException {
        return apiDAOImpl.getBestClients();
    }
}
