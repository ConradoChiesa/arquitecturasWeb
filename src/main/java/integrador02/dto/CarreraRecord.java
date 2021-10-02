package integrador02.dto;

import integrador02.entity.Carrera;
import integrador02.repository.MatriculaRepositoryImpl;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

public class CarreraRecord {
    private String nombre;
    private int anio;
    private int inscriptos;
    private int graduados;

    public CarreraRecord(){ super(); }

    public CarreraRecord(String nombre, int anio, int inscriptos, int graduados) {
        this.nombre = nombre;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.graduados = graduados;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnio() {
        return anio;
    }

    public int getInscriptos() {
        return inscriptos;
    }

    public int getGraduados() {
        return graduados;
    }
}
