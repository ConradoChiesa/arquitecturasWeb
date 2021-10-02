package integrador02.entity;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Matricula {
    @EmbeddedId
    private MatriculaId matriculaId;
    private Date inscripcion;
    @Column
    @Nullable
    private Date graduacion;

    public Matricula() {
        super();
    }

    public Matricula(int id_carrera, int id_estudiante, Date inscripcion, Date graduado) {
        super();
        this.inscripcion = inscripcion;
        this.graduacion = graduado;
        this.matriculaId = new MatriculaId(id_carrera, id_estudiante);
    }

    public MatriculaId getMatriculaId() {
        return matriculaId;
    }

    public Date getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Date inscripcion) {
        this.inscripcion = inscripcion;
    }

    public Date getGraduado() {
        return graduacion;
    }

    public void setGraduado(Date graduado) {
        this.graduacion = graduado;
    }
}
