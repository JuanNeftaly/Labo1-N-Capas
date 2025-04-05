package data;

import model.Paciente;

import java.time.LocalDate;
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
}
