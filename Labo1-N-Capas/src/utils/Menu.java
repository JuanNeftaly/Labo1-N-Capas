package utils;

import model.Paciente;
import model.Doctor;
import model.Cita;
import service.PacienteService;
import service.DoctorService;
import service.CitaService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        PacienteService pacienteService = new PacienteService();
        DoctorService doctorService = new DoctorService();
        CitaService citaService = new CitaService();

        do {
            System.out.println("==================================================");
            System.out.println("       🚑 HOSPITAL DE ZAUN - SISTEMA DE CITAS 🚑");
            System.out.println("==================================================");
            System.out.println("Seleccione una opción:");
            System.out.println("1. 📋 Registrar paciente");
            System.out.println("2. 👨‍⚕️ Registrar doctor");
            System.out.println("3. 📅 Agendar cita médica");
            System.out.println("4. ❌ Cancelar cita médica");
            System.out.println("5. 👀 Consultar citas programadas");
            System.out.println("6. 🔎 Consultar historial de citas de un paciente");
            System.out.println("7. 🩺 Mostrar doctores");
            System.out.println("8. 👥 Mostrar lista de pacientes registrados");
            System.out.println("9. Salir 🚪");
            System.out.print("Opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    menuRegistrarPaciente(pacienteService);
                    break;
                case 2:
                    menuRegistrarDoctor(doctorService);
                    break;
                case 3:
                    menuAgendarCita(doctorService, pacienteService, citaService);
                    break;
                case 4:
                    menuCancelarCita(citaService);
                    break;
                case 5:
                    menuListarCitas(citaService);
                    break;
                case 6:
                    menuHistorialCitasPaciente(citaService);
                    break;
                case 7:
                    doctorService.showAllDoctors();
                    break;
                case 8:
                    pacienteService.mostrarPacientes();
                    break;
                case 9:
                    System.out.println("¡Hasta pronto! 👋");
                    break;
                default:
                    System.out.println("❗ Opción no válida, por favor intente de nuevo.");
            }
            System.out.println();
        } while (option != 9);
        scanner.close();
    }

    public static void menuRegistrarPaciente(PacienteService pacienteService) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 📋 Registrar Paciente ===");
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
        System.out.println("✅ Paciente registrado exitosamente.");
    }

    public static void menuRegistrarDoctor(DoctorService doctorService) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 👨‍⚕️ Registrar Doctor ===");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Apellido: ");
        String lastName = scanner.nextLine();
        System.out.print("DUI: ");
        String dui = scanner.nextLine();
        System.out.print("Año de nacimiento: ");
        int year = scanner.nextInt();
        System.out.print("Mes de nacimiento: ");
        int month = scanner.nextInt();
        System.out.print("Día de nacimiento: ");
        int day = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        LocalDate birthdate = LocalDate.of(year, month, day);

        System.out.print("Año de contratación: ");
        int yearContratacion = scanner.nextInt();
        System.out.print("Mes de contratación: ");
        int monthContratacion = scanner.nextInt();
        System.out.print("Día de contratación: ");
        int dayContratacion = scanner.nextInt();
        scanner.nextLine();
        LocalDate fechaContratacion = LocalDate.of(yearContratacion, monthContratacion, dayContratacion);

        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        doctorService.registerDoctor(name, lastName, dui, birthdate, fechaContratacion, especialidad);
        System.out.println("✅ Doctor registrado exitosamente.");
    }

    public static void menuAgendarCita(DoctorService doctorService, PacienteService pacienteService, CitaService citaService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 📅 Agendar Cita Médica ===");

        // Seleccionar doctor
        System.out.print("Ingrese el ID del doctor: ");
        String doctorId = scanner.nextLine();
        Doctor doctor = doctorService.findDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("❗ Doctor no encontrado.");
            return;
        }

        // Seleccionar paciente
        System.out.print("Ingrese el DUI del paciente: ");
        String dui = scanner.nextLine();
        Paciente paciente = pacienteService.buscarPorDui(dui);
        if (paciente == null) {
            System.out.println("❗ Paciente no encontrado.");
            return;
        }

        // Ingresar fecha de la cita
        System.out.print("Ingrese el año de la cita: ");
        int year = scanner.nextInt();
        System.out.print("Ingrese el mes de la cita: ");
        int month = scanner.nextInt();
        System.out.print("Ingrese el día de la cita: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        LocalDate fecha = LocalDate.of(year, month, day);

        // Determinar si es cita del día
        boolean citaDelDia = fecha.equals(LocalDate.now());
        LocalTime hora = null;
        if (citaDelDia) {
            System.out.print("Ingrese la hora de la cita (HH:mm, formato 24h): ");
            String horaStr = scanner.nextLine();
            try {
                hora = LocalTime.parse(horaStr);
            } catch (Exception e) {
                System.out.println("❗ Formato de hora inválido.");
                return;
            }
        }

        boolean exito = citaService.scheduleCita(doctor, paciente, fecha, hora, citaDelDia);
        if (!exito) {
            System.out.println("❗ No se pudo agendar la cita.");
        }
    }

    public static void menuCancelarCita(CitaService citaService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ❌ Cancelar Cita Médica ===");
        List<Cita> citas = citaService.listAllCitas();
        if (citas.isEmpty()) {
            System.out.println("⚠️ No hay citas programadas.");
            return;
        }
        System.out.println("Listado de citas:");
        for (int i = 0; i < citas.size(); i++) {
            System.out.println(i + ". " + citas.get(i));
        }
        System.out.print("Ingrese el índice de la cita a cancelar: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        citaService.cancelCita(index);
    }

    public static void menuListarCitas(CitaService citaService) {
        System.out.println("=== 👀 Listado de Citas Programadas ===");
        List<Cita> citas = citaService.listAllCitas();
        if (citas.isEmpty()) {
            System.out.println("⚠️ No hay citas programadas.");
            return;
        }
        for (Cita c : citas) {
            System.out.println(c);
        }
    }

    public static void menuHistorialCitasPaciente(CitaService citaService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 🔎 Historial de Citas de un Paciente ===");
        System.out.print("Ingrese el DUI del paciente: ");
        String dui = scanner.nextLine();
        citaService.listCitasByPacienteDui(dui);
    }
}
