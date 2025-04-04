package model;

import java.time.LocalDate;
import utils.IsUnderAge;

public class Paciente extends Persona {

    public Paciente(String name, String lastName, String dui, LocalDate birthdate) {
        super(name, lastName, dui, birthdate);
        IsUnderAge.setDuiIfUnderage(this, dui);
    }

    @Override
    public void setDui(String dui) {
        IsUnderAge.setDuiIfUnderage(this, dui);
    }
}
