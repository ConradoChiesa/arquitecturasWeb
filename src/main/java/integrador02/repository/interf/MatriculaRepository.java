package integrador02.repository.interf;

import integrador02.entity.Matricula;

public interface MatriculaRepository {
    Matricula getMatriculaById (int id_carrera, int id_estudiante);
    Matricula saveMatricula (Matricula matricula);
    void deleteMatricula (Matricula matricula);
}
