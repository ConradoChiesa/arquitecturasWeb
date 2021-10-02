package integrador02;

import integrador02.entity.Carrera;
import integrador02.repository.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Map;

public class Select {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Integ02");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //2f
        /*CarreraRepositoryImpl cri = new CarreraRepositoryImpl(em);
        List<Carrera> query2f = cri.getCarrerasConInscriptos();
        for(Carrera car:query2f){
            System.out.println(car.toString());
        }*/
        //2g
        /*EstudianteRepositoryImpl eri = new EstudianteRepositoryImpl(em);
        List<Estudiante> query2g = eri.getEstudiantesDeCarreraByCity("Analista Programador Universitario", "Reforma");
        for(Estudiante est:query2g){
            System.out.println(est.toString());
        }*/
        //3
        /*MatriculaRepositoryImpl mri = new MatriculaRepositoryImpl(em);
        List<Map<Integer,Integer>> query3 = mri.getInscByYearDESC(1);*/
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}