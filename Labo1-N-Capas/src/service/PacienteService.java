package service;

import dao.PacienteDAO;
import model.Paciente;
import java.time.LocalDate;
import java.util.List;

public class PacienteService {
    private final PacienteDAO pacienteDAO;

    public PacienteService() {
        this.pacienteDAO = new PacienteDAO();
    }

    public void registrarPaciente(Paciente paciente) {
        pacienteDAO.agregarPaciente(paciente);
    }

    public List<Paciente> obtenerTodos() {
        return pacienteDAO.obtenerTodos();
    }

    public Paciente buscarPorDui(String dui) {
        return pacienteDAO.buscarPorDui(dui);
    }

    public List<Paciente> buscarPorNombreApellido(String nombre, String apellido) {
        return pacienteDAO.buscarPorNombreApellido(nombre, apellido);
    }

    public void mostrarPacientes() {
        for (Paciente p : pacienteDAO.obtenerTodos()) {
            System.out.println(p.getName() + " " + p.getLastName() + " - DUI: " + p.getDui());
        }
    }
}
