package integrador02.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Matricula implements Serializable {
    @Id
    @OneToOne
    private Carrera carrera;
    @Id
    @OneToOne@JoinColumn(name = "nroLibreta", unique = true)
    @MapsId
    private Estudiante estudiante;
    private Date inscripcion;
    private boolean graduado;

    public Matricula(){ super(); }

    public Matricula(Carrera carrera, Estudiante estudiante, Date inscripcion, boolean graduado) {
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.inscripcion = inscripcion;
        this.graduado = graduado;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Date getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Date inscripcion) {
        this.inscripcion = inscripcion;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "carrera=" + carrera +
                ", estudiante=" + estudiante +
                ", inscripcion=" + inscripcion +
                ", graduado=" + graduado +
                '}';
    }
}
