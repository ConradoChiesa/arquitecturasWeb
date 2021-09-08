package extractor;

import entity.ProductMaxProfit;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMaxProfitExtractor {



    public static ProductMaxProfit RowMap(ResultSet rs) throws SQLException {
        ProductMaxProfit pmp = new ProductMaxProfit();
        while(rs.next()){
            pmp.setName(rs.getString("name"));
            pmp.setAmount(rs.getFloat("total_amount"));
        }
        return pmp;
    }

}

/*

private static void printResults(String message, ResultSet rs) throws SQLException {
        System.out.println(message);

    }
 */
