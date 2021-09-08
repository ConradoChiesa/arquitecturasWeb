package controller;

import entity.BestClients;
import entity.Client;
import entity.ProductMaxProfit;
import service.ApiService;

import java.sql.SQLException;
import java.util.List;

public class ApiController {

    private ApiService apiService;

    public ApiController() {
        this.apiService = new ApiService();
    }

    public ProductMaxProfit getProductMaxProfit() throws SQLException {
        return apiService.getProductMaxProfit();
    }

    public List<BestClients> getBestClients() throws SQLException {
        return apiService.getBestClients();
    }
}
