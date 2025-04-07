package service;

import dao.PacienteDAO;
import model.Paciente;

import java.util.List;

public class PacienteService {
    private final PacienteDAO pacienteDAO;

    public PacienteService() {
        this.pacienteDAO = new PacienteDAO();
    }

    public void registrarPaciente(Paciente paciente) {
        if (existePaciente(paciente.getDui())) {
            System.out.println("❗ El paciente con DUI " + paciente.getDui() + " ya está registrado.");
            return;
        }else{
            pacienteDAO.agregarPaciente(paciente);
            System.out.println("✅ Paciente registrado exitosamente.");
        }
    }

    public boolean existePaciente(String dui) {
        List<Paciente> pacientes = pacienteDAO.obtenerTodos();
        for (Paciente p : pacientes) {
            if (p.getDui().equals(dui)) {
                return true;
            }
        }
        return false;
    }

    public List<Paciente> obtenerTodos() {
        return pacienteDAO.obtenerTodos();
    }

    public Paciente buscarPorDui(String dui) {
        return pacienteDAO.buscarPorDui(dui);
    }

    public void mostrarPacientes() {
        for (Paciente p : pacienteDAO.obtenerTodos()) {
            System.out.println(p.getName() + " " + p.getLastName() + " - DUI: " + p.getDui());
        }
    }
}
