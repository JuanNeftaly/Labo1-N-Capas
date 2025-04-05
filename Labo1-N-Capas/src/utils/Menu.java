package utils;

import model.Paciente;
import service.PacienteService;
import service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void menu() {

        // cuestion de Java para requerir el teclado
        Scanner scanner = new Scanner(System.in);
        int option;

        // pacientes
        PacienteService pacienteService = new PacienteService();
        List<Paciente> pacientes = pacienteService.obtenerTodos();

        // doctores


        // citas

        do {
            System.out.println("BIENVENIDO AL HOSPITAL DE ZAUN");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Registrar doctor");
            System.out.println("3. Agendar cita médica");
            System.out.println("4. Cancelar cita médica");
            System.out.println("5. Consultar las citas programadas");
            System.out.println("6. Consultar historial de citas de un paciente");
            System.out.println("7. Mostrar los doctores");
            System.out.println("8. Mostrar la lista de pacientes registrados");
            System.out.println("9. Salir");
            System.out.print("Opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Registrar paciente");
                    // fun registrar paciente
                    menuRegistrarPaciente(pacienteService);
                    break;
                case 2:
                    System.out.println("Registrar doctor");
                    break;
                case 3:
                    System.out.println("Agendar cita");
                    break;
                case 4:
                    System.out.println("Cancelar cita");
                    break;
                case 5:
                    System.out.println("Consultar las citas programadas");
                    break;
                case 6:
                    System.out.println("Consultar historial de citas de un paciente");
                    break;
                case 7:
                    System.out.println("Mostrar los doctores");
                    break;
                case 8:
                    System.out.println("Mostrar la lista de pacientes");
                    pacienteService.mostrarPacientes();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (option != 9);

        scanner.close();
    }

    // menu del paciente
    public static void menuRegistrarPaciente(PacienteService pacienteService) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Apellido: ");
        String lastName = scanner.nextLine();
        System.out.print("DUI (si es menor de edad, se asignará automáticamente): ");
        String dui = scanner.nextLine();
        System.out.print("Año de nacimiento: ");
        int year = scanner.nextInt();
        System.out.print("Mes de nacimiento: ");
        int month = scanner.nextInt();
        System.out.print("Día de nacimiento: ");
        int day = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        LocalDate birthdate = LocalDate.of(year, month, day);
        Paciente nuevoPaciente = new Paciente(name, lastName, dui, birthdate);

        pacienteService.registrarPaciente(nuevoPaciente);
    }
}