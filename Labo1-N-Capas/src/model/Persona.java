package model;


import java.time.LocalDate;

public class Persona {
    //nombre, apellido,dui, fecha de nacimiento
    private String name;
    private String lastName;
    private String dui;
    private LocalDate birthdate;

    // constructor
    public Persona(String name, String lastName, String dui, LocalDate birthdate) {
        this.name = name;
        this.lastName = lastName;
        this.dui = dui;
        this.birthdate = birthdate;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public LocalDate getBithdate() {
        return birthdate;
    }

    public void setBithdate(LocalDate bithdate) {
        this.birthdate = bithdate;
    }
//verificar si es menor de 18

    public boolean isUnderage() {
        return LocalDate.now().minusYears(18).isBefore(this.birthdate);
    }


}
