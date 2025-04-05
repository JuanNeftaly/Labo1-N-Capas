package utils;
import model.Paciente;
import java.time.LocalDate;
import java.time.Period;

public class IsUnderAge {
    // es menor verificacion
    public static boolean isUnderAge(LocalDate birthdate){
        return Period.between(birthdate, LocalDate.now()).getYears() < 18;
    }

    // verificar si el chaval es mayor de edad
    public static void setDuiIfUnderage(Paciente paciente, String dui){
        paciente.setDuiDirectly(isUnderAge(paciente.getBirthdate()) ? "00000000-0" : dui);
    }
}