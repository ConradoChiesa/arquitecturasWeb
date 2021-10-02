package integrador02;

import integrador02.entity.Carrera;
import integrador02.entity.Estudiante;
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
        //Repositorios de Entidades
        CarreraRepositoryImpl cri = new CarreraRepositoryImpl(em);
        EstudianteRepositoryImpl eri = new EstudianteRepositoryImpl(em);
        MatriculaRepositoryImpl mri = new MatriculaRepositoryImpl(em);
        em.getTransaction().begin();
        //2c
        /*List<Estudiante> query2c = eri.getEstudiantesByCriteria("Croot");
        System.out.println("--Punto 2c: Lista de Estudiantes con Apellito Croot...--");
        for(Estudiante est:query2c){
            System.out.println(est.toString());
        }*/
        //2d
        /*Estudiante estLib = eri.getEstudianteByUniversityId(249454);
        System.out.println("--Punto 2d: Estudiante en base a numero de libreta...--");
        System.out.println(estLib.toString());*/
        //2e
        /*List<Estudiante> query2e = eri.getEstudiantesByGender('f');
        System.out.println("--Punto 2e: Lista de Estudiante en base a su genero...--");
        for(Estudiante est:query2e){
            System.out.println(est.toString());
        }*/
        //2f
        /*List<Carrera> query2f = cri.getCarrerasConInscriptos();
        System.out.println("--Punto 2f: Lista de Carreras con inscriptos, ordenada por cantidad de inscriptos...--");
        for(Carrera car:query2f){
            System.out.println(car.toString());
        }*/
        //2g
        /*List<Estudiante> query2g = eri.getEstudiantesDeCarreraByCity("Analista Programador Universitario", "Reforma");
        System.out.println("--Punto 2g: Lista de Estudiantes de una Carrera x y de una Ciudad y...--");
        for(Estudiante est:query2g){
            System.out.println(est.toString());
        }*/
        //3
        /*List<Map<Integer,Integer>> query3 = mri.getInscByYearDESC(1);*/
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}