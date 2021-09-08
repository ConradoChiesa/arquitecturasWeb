package daoImpl;

import dao.ApiDAO;
import entity.BestClients;
import entity.Client;
import entity.ProductMaxProfit;
import extractor.ClientExtractor;
import extractor.ProductMaxProfitExtractor;
import persintenceConnection.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ApiDAOImpl implements ApiDAO {

    public ApiDAOImpl() {
    }

    @Override
    public ProductMaxProfit getProductMaxProfit() throws SQLException {
        Connection connection = ConnectionDB.getInstance();
        String query = "SELECT p.name AS name, SUM(p.amount*bp.quantity) AS total_amount " +
                "FROM product p " +
                "NATURAL JOIN billProduct bp GROUP BY p.idProduct " +
                "ORDER BY total_amount DESC LIMIT 0,1";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return ProductMaxProfitExtractor.RowMap(rs);
    }

    @Override
    public List<BestClients> getBestClients() throws SQLException {
        Connection connection = ConnectionDB.getInstance();
        String query = "SELECT c.idClient, c.name, c.email, total_amount " +
                "FROM client c, " +
                "    (SELECT b.idClient, SUM(tp.totalBill) AS total_amount " +
                "    FROM bill b NATURAL JOIN " +
                "        (SELECT bp.idBill, SUM(p.amount) AS totalBill " +
                "        FROM billProduct bp NATURAL JOIN product p " +
                "        GROUP BY bp.idBill) AS tp " +
                "    GROUP BY b.idClient) AS clientList " +
                "WHERE c.idClient=clientList.idClient " +
                "ORDER BY total_amount DESC";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return ClientExtractor.rowMap(rs);
    }
}
