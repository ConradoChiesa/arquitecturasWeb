package integrador02.repository.interf;

import integrador02.entity.Estudiante;

public interface EstudianteRepository {
    Estudiante getEstudianteById (int id);
    Estudiante getEstudianteByName (String firstName);
    Estudiante getEstudianteByLastname (String lastName);
    Estudiante getEstudianteByAge (int age);
    Estudiante getEstudianteByGender(char gender);
    Estudiante getEstudianteByCity(String city);
    Estudiante getEstudianteByUniversityId(Long universityId);
    Estudiante saveEstudiante (Estudiante estudiante);
    void deleteEstudiante (Estudiante estudiante);
}
