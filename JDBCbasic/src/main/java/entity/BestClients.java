package entity;

public class BestClients {

    private int idClient;

    private String name;

    private String email;

    private float totalAmount;

    public BestClients() {
    }

    public BestClients(int idClient, String name, String email, float totalAmount) {
        this.idClient = idClient;
        this.name = name;
        this.email = email;
        this.totalAmount = totalAmount;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return  "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", totalAmount=" + totalAmount;
    }
}
