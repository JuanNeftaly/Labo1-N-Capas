package utils;

import java.time.LocalDate;

public class IsUnderAge {
    public static boolean isUnderage(LocalDate birthdate) {
        return LocalDate.now().minusYears(18).isBefore(birthdate);
    }

    public static void setDuiIfUnderage(Paciente paciente, String dui) {
        if (isUnderage(paciente.getBithdate())) {
            paciente.setDui("00000000-0");
        } else {
            paciente.setDui(dui);
        }
    }
}