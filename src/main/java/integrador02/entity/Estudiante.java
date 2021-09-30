package integrador02.entity;

import javax.persistence.*;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personaID")
    private int id_persona;
    private String nombre;
    private String apellido;
    @Column(name = "anios")
    private int edad;
    private String genero;
    private String ciudad;
    @Column(name = "nroLibreta", unique = true)
    private int id_estudiante;

    public Estudiante() {
        super();
    }

    public Estudiante(String nombre, String apellido, int edad, String genero, String ciudad, int id_estudiante) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.id_estudiante = id_estudiante;
    }

    public int getId_persona() {
        return id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id_persona=" + id_persona +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", id_estudiante=" + id_estudiante +
                '}';
    }
}
