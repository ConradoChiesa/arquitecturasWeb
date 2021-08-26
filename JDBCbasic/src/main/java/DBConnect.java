import controller.ClientController;
import dao.ClientDAOImpl;
import entity.Client;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import service.ClientService;


import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args) throws IOException, SQLException {

        //CreateTables createTables = new CreateTables();
        new CreateTables();
        ClientDAOImpl clientDAOImpl = new ClientDAOImpl();
        ClientService clientService = new ClientService(clientDAOImpl);
        ClientController clientController = new ClientController(clientService);

        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("files/clientes.csv"));
        for(CSVRecord row: parser) {
            int idCliente = Integer.parseInt(row.get("idCliente"));
            String name = row.get("nombre");
            String email = row.get("email");
            clientController.addClient(new Client(idCliente, name, email));
        }
    }




}
