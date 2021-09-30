package integrador02;

import integrador02.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;

public class LoadTables {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Integ02");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Carga de Estudiantes
        //Crear lista de estudiantes y persistir

        //Carga de Carreras
        //Crear lista de carreras y persistir

        //Carga de Matriculas
        //Cargar lista de matriculas y persistir
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
