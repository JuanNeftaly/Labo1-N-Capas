package data;

import model.Cita;
import model.Doctor;
import model.Paciente;
import utils.IdDoctorGenerator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DummyData {

    // create list papu-pacientes
    public static List<Paciente> getPacientesDummy(){
        List<Paciente> pacientes = new ArrayList<Paciente>();

        pacientes.add(new Paciente("Ana", "Ramírez", "12345678-9", LocalDate.of(1990, 5, 21)));
        pacientes.add(new Paciente("Carlos", "Méndez", "98765432-1", LocalDate.of(1985, 11, 3)));
        pacientes.add(new Paciente("Jorge", "Salazar", "45678901-2", LocalDate.of(1978, 3, 30)));
        pacientes.add(new Paciente("Sofía", "Martínez", "", LocalDate.of(2012, 12, 1)));
        pacientes.add(new Paciente("Lucía", "Gómez", "", LocalDate.of(2010, 8, 14)));

        return pacientes;
    }

    public static List<Doctor> getDoctoresDummy(){
        List<Doctor> doctores = new ArrayList<Doctor>();

        doctores.add(new Doctor("Dr. Juan", "Pérez", "12345678-9", LocalDate.of(1975, 4, 15), LocalDate.of(2000, 6, 1), "Cardiología", IdDoctorGenerator.IdZaunGenerator()));
        doctores.add(new Doctor("Dra. María", "González", "98765432-1", LocalDate.of(1980, 7, 22), LocalDate.of(2005, 9, 15), "Pediatría", IdDoctorGenerator.IdZaunGenerator()));
        doctores.add(new Doctor("Dr. Luis", "Martínez", "45678901-2", LocalDate.of(1982, 11, 30), LocalDate.of(2008, 3, 20), "Neurología", IdDoctorGenerator.IdZaunGenerator()));

        return doctores;
    }

    public static List<Cita> getCitasDummy(){
        List<Cita> citas = new ArrayList<Cita>();
        List<Doctor> doctores = getDoctoresDummy();
        List<Paciente> pacientes = getPacientesDummy();

        citas.add(new Cita(doctores.get(0), pacientes.get(0), LocalDate.of(2023, 11, 1), LocalTime.of(10, 0), false));
        citas.add(new Cita(doctores.get(1), pacientes.get(1), LocalDate.of(2023, 11, 2), LocalTime.of(11, 0), false));
        citas.add(new Cita(doctores.get(2), pacientes.get(2), LocalDate.of(2023, 11, 3), LocalTime.of(12, 0), false));
        citas.add(new Cita(doctores.get(0), pacientes.get(3), LocalDate.of(2023, 11, 4), LocalTime.of(13, 0), false));
        citas.add(new Cita(doctores.get(1), pacientes.get(4), LocalDate.of(2023, 11, 5), LocalTime.of(14, 0), false));

        return citas;
    }
}
