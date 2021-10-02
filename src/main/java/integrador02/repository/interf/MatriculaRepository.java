package integrador02.repository.interf;

import integrador02.entity.Matricula;

import java.util.List;
import java.util.Map;

public interface MatriculaRepository {
    Matricula getMatriculaById (int id_carrera, int id_estudiante);
    List<Map<Integer,Integer>> getInscByYearDESC(int studyID);
    List<Map<Integer,Integer>> getGradByYearDESC(int studyID);
    Matricula saveMatricula (Matricula matricula);
    void deleteMatricula (Matricula matricula);
}
