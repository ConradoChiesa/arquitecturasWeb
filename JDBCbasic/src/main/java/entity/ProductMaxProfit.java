package entity;

public class ProductMaxProfit {

    private String name;

    private float amount;

    public ProductMaxProfit() {
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

    @Override
    public String toString() {
        return "name='" + name + '\'' +
               ", amount=" + amount;
    }
}
