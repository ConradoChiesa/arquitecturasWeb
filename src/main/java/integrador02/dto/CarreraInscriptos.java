package integrador02.dto;

import integrador02.entity.Carrera;

public class CarreraInscriptos extends Carrera {
    private int cantInscriptos;

    public CarreraInscriptos() { super(); }

    public CarreraInscriptos(String nombre, int cantInscriptos) {
        super(nombre);
        this.cantInscriptos = cantInscriptos;
    }

    public int getCantInscriptos() {
        return cantInscriptos;
    }

    @Override
    public String toString() {
        return "CarreraInscriptos{" +
                "carrera=" + this.getNombre()+
                "cantInscriptos=" + this.cantInscriptos +
                '}';
    }
}
