package entity;

public class Bill {

    private int idBill;

    private int idCliente;

    public Bill() {
    }

    public Bill(int idBill, int idCliente) {
        this.idBill = idBill;
        this.idCliente = idCliente;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
