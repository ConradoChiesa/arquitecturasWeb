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
        //Carga de Estudiantes - Punto 2a
        System.out.println("--Cargando Estudiantes....--");
        Estudiante est1 = new Estudiante("Joaquin", "Mancini", 28, 'm', "Tandil", 1);
        Estudiante est2 = new Estudiante("Maria Jose", "Mancini", 24, 'f', "Tandil", 2);
        em.persist(est1);
        em.persist(est2);
        //Carga de Carreras
        System.out.println("--Cargando Carreras....--");
        Carrera carr1 = new Carrera("TUDAI");
        Carrera carr2 = new Carrera("Med. Veterinaria");
        em.persist(carr1);
        em.persist(carr2);
        //Carga de Matriculas - Punto 2b
        System.out.println("--Matriculando Estudiantes a Carreras....--");
        Matricula mat1 = new Matricula(carr1.getId_carrera(), est1.getId_estudiante(), Date.valueOf("2018-03-30"), Date.valueOf("2022-03-30"));
        Matricula mat2 = new Matricula(carr2.getId_carrera(), est2.getId_estudiante(), Date.valueOf("2017-04-30"), Date.valueOf("2023-03-30"));
        em.persist(mat1);
        em.persist(mat2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}