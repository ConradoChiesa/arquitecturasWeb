package integrador02;

import integrador02.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;

public class Insert {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Integ02");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Carga de Estudiantes
        Estudiante est1 = new Estudiante("Joaquin", "Mancini", 28, "Hombre", "Tandil", 1);
        Estudiante est2 = new Estudiante("Maria Jose", "Mancini", 24, "Mujer", "Tandil", 2);
        em.persist(est1);
        em.persist(est2);
        //Carga de Carreras
        Carrera carr1 = new Carrera("TUDAI");
        Carrera carr2 = new Carrera("Medicina Veterinaria");
        em.persist(carr1);
        em.persist(carr2);
        //Carga de Matriculas
        Matricula mat1 = new Matricula(carr1, est1, Date.valueOf("2018-03-30"), false);
        Matricula mat2 = new Matricula(carr2, est2, Date.valueOf("2017-04-30"), false);
        em.persist(mat1);
        em.persist(mat2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}