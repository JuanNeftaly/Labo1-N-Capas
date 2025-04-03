package model;
import java.time.LocalDate;

// heredando de persona
public class Doctor extends Persona {
    private LocalDate fechaDeContratacion;
    private String especialidad;
    private String id;

    public Doctor(String name, String lastName, LocalDate birthdate, LocalDate fechaDeContratacion, String especialidad, String id) {
        super(name, lastName, "00000000-0", birthdate);
        this.fechaDeContratacion = fechaDeContratacion;
        this.especialidad = especialidad;
        this.id = id;
    }

    public LocalDate getFechaDeContratacion() {
        return fechaDeContratacion;
    }

    public void setFechaDeContratacion(LocalDate fechaDeContratacion) {
        this.fechaDeContratacion = fechaDeContratacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}