package service;

import dao.PacienteDAO;
import model.Paciente;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PacienteService {
    private PacienteDAO dao;

    public PacienteService() {
        this.dao = new PacienteDAO();
    }

    public void registrarPaciente(Paciente paciente) {
        dao.agregarPaciente(paciente);
        System.out.println("Paciente registrado exitosamente.");
    }

    public Paciente buscarPorDui(String dui) {
        return dao.buscarPorDui(dui);
    }

    public List<Paciente> buscarPorNombreApellido(String nombre, String apellido) {
        return dao.buscarPorNombreApellido(nombre, apellido);
    }

    public List<Paciente> obtenerTodos() {
        return dao.obtenerTodos();
    }
}
