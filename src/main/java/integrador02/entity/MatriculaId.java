package integrador02.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MatriculaId implements Serializable {
    @Column(name = "carreraID")
    private int id_carrera;
    @Column(name = "estudianteID")
    private int id_estudiante;

    public MatriculaId() {
        super();
    }

    public MatriculaId(int id_carrera, int id_estudiante) {
        super();
        this.id_carrera = id_carrera;
        this.id_estudiante = id_estudiante;
    }

    private void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    private void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public Integer getId_carrera() {
        return id_carrera;
    }

    public Integer getId_estudiante() {
        return id_estudiante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatriculaId that = (MatriculaId) o;
        return id_carrera == that.id_carrera && id_estudiante == that.id_estudiante;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_carrera, id_estudiante);
    }
}
