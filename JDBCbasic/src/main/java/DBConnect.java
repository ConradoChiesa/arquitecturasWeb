import controller.BillController;
import controller.ClientController;
import entity.Bill;
import entity.Client;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args) throws IOException, SQLException {

        //CreateTables createTables = new CreateTables();
        new CreateTables();
        ClientController clientController = new ClientController();
        BillController billController = new BillController();

        CSVParser clientes = CSVFormat.DEFAULT.withHeader().parse(new FileReader("files/clientes.csv"));
        for(CSVRecord row: clientes) {
            int idCliente = Integer.parseInt(row.get("idCliente"));
            String name = row.get("nombre");
            String email = row.get("email");
            clientController.addClient(new Client(idCliente, name, email));
        }

        CSVParser facturas = CSVFormat.DEFAULT.withHeader().parse(new FileReader("files/facturas.csv"));
        for(CSVRecord row: facturas) {
            int idBill = Integer.parseInt(row.get("idFactura"));
            int idCliente = Integer.parseInt(row.get("idCliente"));
            billController.addBill(new Bill(idBill, idCliente));
        }
    }




}
