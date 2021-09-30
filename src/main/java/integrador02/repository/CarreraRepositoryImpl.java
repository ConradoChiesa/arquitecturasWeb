package integrador02.repository;

import integrador02.entity.Carrera;
import integrador02.entity.Estudiante;
import integrador02.repository.interf.CarreraRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CarreraRepositoryImpl implements CarreraRepository {
    private EntityManager em;

    public CarreraRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Carrera getCarreraById(int id) {
        return em.find(Carrera.class, id);
    }

    @Override
    public Carrera getCarreraByName(String name) {
        TypedQuery<Carrera> q = em.createQuery(
                "SELECT c FROM Carrera c WHERE c.nombre = :name", Carrera.class
        );
        q.setParameter("name", name);
        return q.getSingleResult();
    }

    @Override
    public Carrera saveCarrera(Carrera carrera) {
        if (carrera.getId_carrera() == null) {
            em.persist(carrera);
        } else {
            carrera = em.merge(carrera);
        }
        return carrera;
    }

    @Override
    public void deleteCarrera(Carrera carrera) {
        if (em.contains(carrera)) {
            em.remove(carrera);
        } else {
            em.merge(carrera);
        }
    }
}
