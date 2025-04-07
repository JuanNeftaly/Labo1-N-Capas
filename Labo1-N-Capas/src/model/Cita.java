package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    private Doctor doctor;
    private Paciente paciente;
    private LocalDate fecha;
    private LocalTime hora;
    private boolean citaDelDia;
    private boolean asistio;
    private String especialidad;

    public Cita(Doctor doctor, Paciente paciente, LocalDate fecha, LocalTime hora, boolean citaDelDia) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.citaDelDia = citaDelDia;
        this.asistio = false;
        this.especialidad = doctor.getEspecialidad();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public boolean isCitaDelDia() {
        return citaDelDia;
    }

    public boolean isAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "doctor=" + doctor.getName() + " " + doctor.getLastName() +
                ", paciente=" + paciente.getName() + " " + paciente.getLastName() +
                ", especialidad=" + especialidad +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", citaDelDia=" + citaDelDia +
                ", asistio=" + asistio +
                '}';
    }
}

