package persintenceConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection connection;

    public ConnectionDB() {
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();;
            System.exit(1);
        }
        String uri = "jdbc:mysql://localhost:3306/exampleDB?createDatabaseIfNotExist=true";
        try {
            connection = DriverManager.getConnection(uri, "root", "123");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
/*
    private void instanceConnection() {

        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();;
            System.exit(1);
        }

        String uri = "jdbc:mysql://localhost:3306/exampleDB";

        try {
            connection = DriverManager.getConnection(uri, "root", "123");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
*/
    public static Connection getInstance() {
        return connection;
    }
/*
    public static void connectionClose() throws SQLException {
        connection.close();
    }
*/
}
