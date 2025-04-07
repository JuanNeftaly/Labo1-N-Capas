package service;

import dao.CitaDAO;
import model.Cita;
import model.Doctor;
import model.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CitaService {
    private final CitaDAO citaDAO;

    public CitaService() {
        this.citaDAO = new CitaDAO();
    }

    public boolean scheduleCita(Doctor doctor, Paciente paciente, LocalDate fecha, LocalTime hora, boolean citaDelDia) {
        List<Cita> citas = citaDAO.getAllCitas();

        for (Cita c : citas) {
            if (c.getFecha().equals(fecha) && c.getHora().equals(hora)) {
                if (c.getDoctor().equals(doctor) || c.getPaciente().equals(paciente)) {
                    System.out.println("❗ El doctor o paciente ya tiene una cita programada en la misma fecha y hora.");
                    return false;
                }
            }
        }

        Cita nuevaCita = new Cita(doctor, paciente, fecha, hora, citaDelDia);
        citaDAO.addCita(nuevaCita);
        System.out.println("✅ Cita agendada exitosamente.");
        return true;
    }

    public List<Cita> listAllCitas() {
        return citaDAO.getAllCitas();
    }

    public void cancelCita(int index) {
        List<Cita> citas = citaDAO.getAllCitas();
        if (index >= 0 && index < citas.size()) {
            citas.remove(index);
            System.out.println("✅ Cita cancelada exitosamente.");
        } else {
            System.out.println("❗ Índice de cita inválido.");
        }
    }

    public List<Cita> listCitasByPacienteDui(String dui) {
        List<Cita> citas = citaDAO.getAllCitas();
        List<Cita> citasPaciente = new ArrayList<>();
        for (Cita c : citas) {
            if (c.getPaciente().getDui().equals(dui)) {
                citasPaciente.add(c);
            }
        }
        return citasPaciente;
    }
}