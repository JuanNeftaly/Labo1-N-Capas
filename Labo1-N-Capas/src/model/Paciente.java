package model;
import java.time.LocalDate;

public class Paciente extends Persona {

    public Paciente(String name, String lastName, String dui, LocalDate birthdate) {
        super(name, lastName, dui, birthdate);
        if (isUnderage()) {
            setDui("00000000-0");
        }
    }

    @Override
    public void setDui(String dui) {
        if (isUnderage()) {
            super.setDui("00000000-0");
        } else {
            super.setDui(dui);
        }
    }
}

