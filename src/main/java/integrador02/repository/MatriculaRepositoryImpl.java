package integrador02.repository;

import integrador02.entity.Matricula;
import integrador02.entity.MatriculaId;
import integrador02.repository.interf.MatriculaRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Map<Integer,Integer>> getInscByYearDESC(int studyID) {
        TypedQuery<Map<Integer,Integer>> q = (TypedQuery<Map<Integer, Integer>>) em.createNativeQuery(
                "SELECT year(m.inscripcion), COUNT(year(m.inscripcion)) AS yi FROM integrador02.Matricula m WHERE m.carreraID = :studyID GROUP BY m.carreraID, year(m.inscripcion) ORDER BY m.carreraID, year(m.inscripcion)"
        );
        q.setParameter("studyID", studyID);
        return q.getResultList();
    }

    @Override
    public List<Map<Integer,Integer>> getGradByYearDESC(int studyID) {
        TypedQuery<Map<Integer,Integer>> q = (TypedQuery<Map<Integer, Integer>>) em.createNativeQuery(
                "SELECT m.carreraID, year(m.graduacion), COUNT(year(m.graduacion)) AS yi FROM integrador02.Matricula m WHERE year(m.graduacion) IS NOT NULL GROUP BY m.carreraID, year(m.graduacion) ORDER BY m.carreraID, year(m.graduacion)"
        );
        q.setParameter("studyID", studyID);
        return q.getResultList();
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
