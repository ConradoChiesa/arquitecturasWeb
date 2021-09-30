package integrador02.repository;

import integrador02.entity.Estudiante;
import integrador02.repository.interf.EstudianteRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
    public Estudiante getEstudianteByGender(String gender) {
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

    @Override
    public Estudiante getEstudianteByUniversityId(String universityId) {
        TypedQuery<Estudiante> q = em.createQuery(
                "SELECT e FROM Estudiante e WHERE e.id_estudiante = :universityId", Estudiante.class
        );
        q.setParameter("universityId", universityId);
        return q.getSingleResult();
    }
}
