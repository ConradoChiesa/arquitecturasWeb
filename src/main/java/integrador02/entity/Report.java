package integrador02.entity;

public class Report {
    private String carrera;
    private Integer anio;
    private Integer inscriptos;
    private Integer graduados;

    public Report(){ super(); }

    public Report(String carrera, Integer anio, Integer inscriptos, Integer graduados) {
        this.carrera = carrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.graduados = graduados;
    }

    public String getCarrera() {
        return carrera;
    }

    public Integer getAnio() {
        return anio;
    }

    public Integer getInscriptos() {
        return inscriptos;
    }

    public Integer getGraduados() {
        return graduados;
    }
}
