package extractor;

import entity.BestClients;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientExtractor {
    public static List<BestClients> rowMap(ResultSet rs) throws SQLException {
        List<BestClients> bc = new ArrayList<>();
        while(rs.next()){
            BestClients bestClients = new BestClients();
            bestClients.setIdClient(rs.getInt("idClient"));
            bestClients.setName(rs.getString("name"));
            bestClients.setEmail(rs.getString("email"));
            bestClients.setTotalAmount(rs.getFloat("total_amount"));
            bc.add(bestClients);
        }
        return bc;
    }
}