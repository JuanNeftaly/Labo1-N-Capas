package utils;

import java.time.LocalDate;

public class IsUnderAge {
    public static boolean isUnderage(LocalDate birthdate) {
        return LocalDate.now().minusYears(18).isBefore(birthdate);
    }
}