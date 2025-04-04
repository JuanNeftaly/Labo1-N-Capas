package utils;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
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

            switch (option) {
                case 1:
                    System.out.println("Registrar paciente");
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
}