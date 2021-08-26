import controller.BillController;
import controller.BillProductController;
import controller.ClientController;
import controller.ProductController;
import entity.Bill;
import entity.BillProduct;
import entity.Client;
import entity.Product;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args) throws Exception {

        //Creación de tablas en BBDD
        new CreateTables();

        //Instaciamos los controladores
        ClientController clientController = new ClientController();
        BillController billController = new BillController();
        BillProductController billProductController = new BillProductController();
        ProductController productController = new ProductController();

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

    }
/*
Query punto 3
SELECT * FROM product p join billProduct bp ON p.idProduct = bp.idProduct WHERE (SELECT MAX(p.amount*bp.quantity)) limit 1;
 */





}
