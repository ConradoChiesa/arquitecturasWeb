package integrador02;

import integrador02.entity.*;
import integrador02.repository.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.List;

public class Select {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Integ02");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //2g
        EstudianteRepositoryImpl eri = new EstudianteRepositoryImpl(em);
        List<Estudiante> carr = eri.getEstudiantesDeCarreraByCity("Analista Programador Universitario", "Reforma");
        for(Estudiante est:carr){
            System.out.println(est.toString());
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}