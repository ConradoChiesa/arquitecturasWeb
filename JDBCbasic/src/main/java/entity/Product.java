package entity;

public class Product {

    private int idProduct;

    private String name;

    private int amount;

    public Product() {
    }

    public Product(int idProduct, String name, int amount) {
        this.idProduct = idProduct;
        this.name = name;
        this.amount = amount;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
