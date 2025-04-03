package model;


import java.time.LocalDate;

public class Persona {
    //nombre, apellido,dui, fecha de nacimiento
    private String name;
    private String lastName;
    private String dui;
    private LocalDate bithdate;

    // constructor
    public Persona(String name, String lastName, String dui, LocalDate bithdate) {
        this.name = name;
        this.lastName = lastName;
        this.dui = dui;
        this.bithdate = bithdate;
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
        return bithdate;
    }

    public void setBithdate(LocalDate bithdate) {
        this.bithdate = bithdate;
    }


}
