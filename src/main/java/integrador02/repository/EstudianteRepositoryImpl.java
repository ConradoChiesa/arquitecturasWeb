package integrador02.repository;

import integrador02.entity.Estudiante;
import integrador02.repository.interf.EstudianteRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    private EntityManager em;

    public EstudianteRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Estudiante getEstudianteById(int id) {
        return em.find(Estudiante.class, id);
    }

    @Override
    public Estudiante getEstudianteByName(String firstName) {
        TypedQuery<Estudiante> q = em.createQuery(
                "SELECT e FROM Estudiante e WHERE e.nombre = :firstName", Estudiante.class
        );
        q.setParameter("firstName", firstName);
        return q.getSingleResult();
    }

    @Override
    public Estudiante getEstudianteByLastname(String lastName) {
        TypedQuery<Estudiante> q = em.createQuery(
                "SELECT e FROM Estudiante e WHERE e.apellido = :lastName", Estudiante.class
        );
        q.setParameter("lastName", lastName);
        return q.getSingleResult();
    }

    @Override
    public Estudiante getEstudianteByAge(int age) {
        TypedQuery<Estudiante> q = em.createQuery(
                "SELECT e FROM Estudiante e WHERE e.edad = :age", Estudiante.class
        );
        q.setParameter("age", age);
        return q.getSingleResult();
    }

    @Override
    public Estudiante getEstudianteByGender(char gender) {
        TypedQuery<Estudiante> q = em.createQuery(
                "SELECT e FROM Estudiante e WHERE e.genero = :gender", Estudiante.class
        );
        q.setParameter("gender", gender);
        return q.getSingleResult();
    }

    @Override
    public Estudiante getEstudianteByCity(String city) {
        TypedQuery<Estudiante> q = em.createQuery(
                "SELECT e FROM Estudiante e WHERE e.ciudad = :city", Estudiante.class
        );
        q.setParameter("city", city);
        return q.getSingleResult();
    }

    //2d
    @Override
    public Estudiante getEstudianteByUniversityId(Long universityId) {
        TypedQuery<Estudiante> q = em.createQuery(
                "SELECT e FROM Estudiante e WHERE e.id_estudiante = :universityId", Estudiante.class
        );
        q.setParameter("universityId", universityId);
        return q.getSingleResult();
    }

    //2a
    @Override
    public Estudiante saveEstudiante(Estudiante estudiante) {
        if (estudiante.getId_estudiante() == null) {
            em.persist(estudiante);
        } else {
            estudiante = em.merge(estudiante);
        }
        return estudiante;
    }

    @Override
    public void deleteEstudiante(Estudiante estudiante) {
        if (em.contains(estudiante)) {
            em.remove(estudiante);
        } else {
            em.merge(estudiante);
        }
    }

    //2c
    public List<Estudiante> getEstudiantesByCriteria(String lastName) {
        TypedQuery<Estudiante> q = em.createQuery(
                "SELECT e FROM Estudiante e WHERE e.apellido = :lastName ORDER BY e.id_estudiante ASC", Estudiante.class
        );
        q.setParameter("lastName", lastName);
        return q.getResultList();
    }

    //2e
    public List<Estudiante> getEstudiantesByGender(char gender) {
        TypedQuery<Estudiante> q = em.createQuery(
                "SELECT e FROM Estudiante e WHERE e.genero = :gender", Estudiante.class
        );
        q.setParameter("gender", gender);
        return q.getResultList();
    }

    public List<Estudiante> getEstudiantesDeCarreraByCity(String study, String city){
        TypedQuery<Estudiante> q = em.createQuery(
                "SELECT e FROM Estudiante e WHERE e.id_estudiante IN (SELECT m.matriculaId.id_estudiante FROM Matricula m, Carrera c WHERE m.matriculaId.id_carrera=c.id_carrera AND c.nombre= :study) AND e.ciudad = :city", Estudiante.class
        );
        q.setParameter("study", study);
        q.setParameter("city", city);
        return q.getResultList();
    }
}
