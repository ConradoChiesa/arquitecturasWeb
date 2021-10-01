package integrador02.repository;

import integrador02.entity.Matricula;
import integrador02.entity.MatriculaId;
import integrador02.repository.interf.MatriculaRepository;

import javax.persistence.EntityManager;

public class MatriculaRepositoryImpl implements MatriculaRepository {
    private EntityManager em;

    public MatriculaRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Matricula getMatriculaById(int id_carrera, int id_estudiante) {
        MatriculaId mi = new MatriculaId(id_carrera, id_estudiante);
        return em.find(Matricula.class, mi);
    }

    //2b
    @Override
    public Matricula saveMatricula(Matricula matricula) {
        if (matricula.getMatriculaId().getId_carrera() == null && matricula.getMatriculaId().getId_estudiante() == null) {
            em.persist(matricula);
        } else {
            matricula = em.merge(matricula);
        }
        return matricula;
    }

    @Override
    public void deleteMatricula(Matricula matricula) {
        if (em.contains(matricula)) {
            em.remove(matricula);
        } else {
            em.merge(matricula);
        }
    }
}
