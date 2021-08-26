package entity;

public class Product {

    private int idProduct;

    private String name;

    private float amount;

    public Product(int idProduct, String name, float amount) {
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
