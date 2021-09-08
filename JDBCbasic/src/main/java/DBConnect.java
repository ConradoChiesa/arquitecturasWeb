import controller.*;
import entity.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.util.Iterator;

public class DBConnect {
    public static void main(String[] args) throws Exception {

        //Creación de tablas en BBDD
        new CreateTables();

        //Instaciamos los controladores
        ClientController clientController = new ClientController();
        BillController billController = new BillController();
        BillProductController billProductController = new BillProductController();
        ProductController productController = new ProductController();
        ApiController apiController = new ApiController();

        //Lectura de archivos CSV y carga de datos
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

        CSVParser facturasProductos = CSVFormat.DEFAULT.withHeader().parse(new FileReader("files/facturas-productos.csv"));
        for(CSVRecord row: facturasProductos) {
            int idBill = Integer.parseInt(row.get("idFactura"));
            int idProduct = Integer.parseInt(row.get("idProducto"));
            int quantity = Integer.parseInt(row.get("cantidad"));
            billProductController.addBillProduct(new BillProduct(idBill, idProduct, quantity));
        }

        CSVParser Productos = CSVFormat.DEFAULT.withHeader().parse(new FileReader("files/productos.csv"));
        for(CSVRecord row: Productos) {
            //    public Product(int idProduct, String name, int amount) {
            int idProduct = Integer.parseInt(row.get("idProducto"));
            String name = row.get("nombre");
            float amount = Integer.parseInt(row.get("valor"));
            productController.addProduct(new Product(idProduct, name, amount));
        }

        System.out.println("Producto con el que más se recaudo: ");
        System.out.println(apiController.getProductMaxProfit().toString());
        System.out.println("\nLista de mejores clientes: ");
        Iterator<BestClients> bestClientsIterator = apiController.getBestClients().iterator();
        while (bestClientsIterator.hasNext()) {
            System.out.println(bestClientsIterator.next().toString());

        }

    }

}
