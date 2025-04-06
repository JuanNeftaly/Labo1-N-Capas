package service;

import dao.CitaDAO;
import model.Cita;
import model.Doctor;
import model.Paciente;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CitaService {
    private final CitaDAO citaDAO;

    public CitaService() {
        this.citaDAO = new CitaDAO();
    }

    public boolean scheduleCita(Doctor doctor, Paciente paciente, LocalDate fecha, LocalTime hora, boolean citaDelDia) {
        if (!citaDelDia) {
            LocalTime availableHour = findAvailableHour(doctor, paciente, fecha);
            if (availableHour == null) {
                System.out.println("No hay horarios disponibles para la fecha " + fecha);
                return false;
            }
            hora = availableHour;
        } else {
            if (hora.isBefore(LocalTime.of(8, 0)) || hora.isAfter(LocalTime.of(16, 0))) {
                System.out.println("La hora debe ser entre 8:00 y 16:00 para citas del día.");
                return false;
            }
        }

        for (Cita c : citaDAO.getAllCitas()) {
            if (c.getFecha().equals(fecha) && c.getHora().equals(hora)) {
                if (c.getDoctor().getId().equals(doctor.getId())) {
                    System.out.println("El doctor ya tiene una cita a esa hora.");
                    return false;
                }
                if (c.getPaciente().getDui().equals(paciente.getDui())) {
                    System.out.println("El paciente ya tiene una cita a esa hora.");
                    return false;
                }
            }
        }

        Cita nuevaCita = new Cita(doctor, paciente, fecha, hora, citaDelDia);
        citaDAO.addCita(nuevaCita);
        System.out.println("Cita agendada correctamente: " + nuevaCita);
        return true;
    }

    private LocalTime findAvailableHour(Doctor doctor, Paciente paciente, LocalDate fecha) {
        for (int h = 8; h <= 15; h++) {
            LocalTime candidate = LocalTime.of(h, 0);
            boolean conflict = false;
            for (Cita c : citaDAO.getAllCitas()) {
                if (c.getFecha().equals(fecha) && c.getHora().equals(candidate)) {
                    if (c.getDoctor().getId().equals(doctor.getId()) || c.getPaciente().getDui().equals(paciente.getDui())) {
                        conflict = true;
                        break;
                    }
                }
            }
            if (!conflict) {
                return candidate;
            }
        }
        return null;
    }

    public void cancelCita(int index) {
        List<Cita> citas = citaDAO.getAllCitas();
        if (index >= 0 && index < citas.size()) {
            Cita cita = citas.get(index);
            citaDAO.removeCita(cita);
            System.out.println("Cita cancelada: " + cita);
        } else {
            System.out.println("Índice de cita inválido.");
        }
    }

    public List<Cita> listAllCitas() {
        return citaDAO.getAllCitas();
    }

    public void listCitasByDoctorId(String doctorId) {
        for (Cita c : citaDAO.getAllCitas()) {
            if (c.getDoctor().getId().equals(doctorId)) {
                System.out.println(c);
            }
        }
    }

    public void listCitasByPacienteDui(String dui) {
        for (Cita c : citaDAO.getAllCitas()) {
            if (c.getPaciente().getDui().equals(dui)) {
                System.out.println(c);
            }
        }
    }
}
