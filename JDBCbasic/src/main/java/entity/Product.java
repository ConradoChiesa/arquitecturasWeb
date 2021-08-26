package entity;

public class Product {
    private int idProducto;

    private String nombre;

    private int amount;

    public Product() {
    }

    public Product(int idProducto, String nombre, int amount) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.amount = amount;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
