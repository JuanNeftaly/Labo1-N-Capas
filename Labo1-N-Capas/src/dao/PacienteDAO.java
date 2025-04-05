package dao;

import model.Paciente;
import data.DummyData;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteDAO {
    private List<Paciente> pacientes;

    public PacienteDAO() {
        this.pacientes = DummyData.getPacientesDummy();
    }

    public List<Paciente> obtenerTodos() {
        return pacientes;
    }

    public List<Paciente> buscarPorNombreApellido(String nombre, String apellido) {
        return pacientes.stream()
                .filter(p -> p.getName().equalsIgnoreCase(nombre)
                        && p.getLastName().equalsIgnoreCase(apellido))
                .collect(Collectors.toList());
    }

    public Paciente buscarPorDui(String dui) {
        return pacientes.stream()
                .filter(p -> p.getDui().equals(dui))
                .findFirst()
                .orElse(null);
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }
}
