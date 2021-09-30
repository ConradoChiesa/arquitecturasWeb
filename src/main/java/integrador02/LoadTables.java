package integrador02;

import integrador02.entity.*;
import integrador02.repository.*;
import org.apache.commons.csv.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileReader;
import java.sql.Date;

public class LoadTables {
    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Integ02");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Carga de Carreras
        loadCarreras("assets/carreras.csv", em);
        //Carga de Estudiantes
        loadEstudiantes("assets/estudiantes.csv", em);
        //Carga de Matriculas
        loadMatriculas("assets/matriculas.csv", em);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void loadEstudiantes(String path, EntityManager em) throws Exception {
        //Lectura de archivos CSV y carga de datos
        EstudianteRepositoryImpl eri = new EstudianteRepositoryImpl(em);
        CSVParser Estudiantes = CSVFormat.DEFAULT.withHeader().parse(new FileReader(path));
        for (CSVRecord row : Estudiantes) {
            String nombre = row.get("nombre");
            String apellido = row.get("apellido");
            int edad = Integer.parseInt(row.get("edad"));
            String genero = row.get("genero");
            String ciudad = row.get("ciudad");
            int id_estudiante = Integer.parseInt(row.get("id_estudiante"));
            eri.saveEstudiante(new Estudiante(nombre, apellido, edad, genero, ciudad, id_estudiante));
        }
    }

    private static void loadCarreras(String path, EntityManager em) throws Exception {
        //Lectura de archivos CSV y carga de datos
        CarreraRepositoryImpl cri = new CarreraRepositoryImpl(em);
        CSVParser Carrera = CSVFormat.DEFAULT.withHeader().parse(new FileReader(path));
        for (CSVRecord row : Carrera) {
            String nombre = row.get("nombre");
            cri.saveCarrera(new Carrera(nombre));
        }
    }

    private static void loadMatriculas(String path, EntityManager em) throws Exception {
        //Lectura de archivos CSV y carga de datos
        MatriculaRepositoryImpl mri = new MatriculaRepositoryImpl(em);
        CSVParser Matricula = CSVFormat.DEFAULT.withHeader().parse(new FileReader(path));
        for (CSVRecord row : Matricula) {
            int carreraID = Integer.parseInt(row.get("carreraID"));
            int nroLibreta = Integer.parseInt(row.get("nroLibreta"));
            Date inscripcion = Date.valueOf(row.get("inscripcion"));
            Date graduacion = (row.get("graduacion").equals("null")) ? null : Date.valueOf(row.get("graduacion"));
            mri.saveMatricula(new Matricula(carreraID, nroLibreta, inscripcion, graduacion));
        }
    }
}
