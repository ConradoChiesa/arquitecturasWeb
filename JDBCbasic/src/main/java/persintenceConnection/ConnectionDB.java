package persintenceConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private Connection connection = null;

    public ConnectionDB() {
    }

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

    public Connection getInstance() {
        if (connection == null) {
            instanceConnection();
        }
        return connection;

    }

    public void connectionClose() throws SQLException {
        connection.close();
        connection = null;
    }

}
