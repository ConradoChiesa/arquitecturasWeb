package integrador02.entity;

import javax.persistence.*;

@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "carreraID")
    private int id_carrera;
    private String nombre;

    public Carrera() {
        super();
    }

    public Carrera(String nombre) {
        super();
        this.nombre = nombre;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id_carrera=" + id_carrera +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
