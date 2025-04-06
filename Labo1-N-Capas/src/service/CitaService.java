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
            if (hora.isBefore(LocalTime.of(8, 0)) || hora.isAfter(LocalTime.of(16, 0))) {
                System.out.println("La hora debe ser entre 8:00 y 16:00 para citas futuras.");
                return false;
            } else {
                fecha = LocalDate.now();
            }
            for (Cita c : citaDAO.getAllCitas()) {
                if (c.getFecha().equals(fecha) && c.getHora().equals(hora)) {
                    if (c.getDoctor().getId().equals(doctor.getId())) {
                        System.out.println("El doctor ya tiene una Cita a esa hora.");
                        return false;
                    }
                    if (c.getPaciente().getDui().equals(paciente.getDui())) {
                        System.out.println("El paciente ya tiene una Cita a esa hora.");
                        return false;
                    }
                }
            }

        }
        Cita nuevaCita = new Cita(doctor, paciente, fecha, hora, citaDelDia);
        citaDAO.addCita(nuevaCita);
        return true;
    }

    public void cancelCita(Cita cita) {
        citaDAO.removeCita(cita);
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
}
