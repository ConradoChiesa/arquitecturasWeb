package integrador02.repository.interf;

import integrador02.entity.Carrera;

public interface CarreraRepository {
    Carrera getCarreraById (int id);
    Carrera getCarreraByName (String name);
    Carrera saveCarrera (Carrera carrera);
    void deleteCarrera (Carrera carrera);
}
