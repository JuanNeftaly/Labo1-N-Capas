package model;
import java.time.LocalDate;

// herencia de persona
public class Paciente extends Persona {

    public Paciente(String name, String lastName, String dui, LocalDate birthdate) {
        super(name, lastName, dui, birthdate);
        if (isUnderage()) {
            setDui("00000000-0");
        }
    }

    // metodo para verificar edad
    @Override
    public void setDui(String dui) {
        if (isUnderage()) {
            super.setDui("00000000-0");
        } else {
            super.setDui(dui);
        }
    }
}

