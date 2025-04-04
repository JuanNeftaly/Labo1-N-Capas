package utils;
import model.Paciente;
import java.time.LocalDate;

public class IsUnderAge {
    public static boolean isUnderage(LocalDate birthdate) {
        return LocalDate.now().minusYears(18).isBefore(birthdate);
    }

    // verificamos si el chaval es mayor de edad, sino pal suelo el DUI
    public static void setDuiIfUnderage(Paciente paciente, String dui) {
        if (isUnderage(paciente.getBithdate())) {
            paciente.setDui("00000000-0");
        } else {
            paciente.setDui(dui);
        }
    }
}