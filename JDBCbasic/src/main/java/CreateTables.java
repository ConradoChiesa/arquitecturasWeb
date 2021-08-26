import persintenceConnection.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateTables {

    private ConnectionDB connectionDB = new ConnectionDB();

    public CreateTables() throws SQLException {
        Connection connection = connectionDB.getInstance();
        String table = "CREATE TABLE IF NOT EXISTS client(" +
                "idClient INT," +
                "name VARCHAR(500)," +
                "email VARCHAR(500)," +
                "PRIMARY KEY(idClient))";
        connection.prepareStatement(table).execute();
        connection.commit();

        connectionDB.connectionClose();
    }
}
