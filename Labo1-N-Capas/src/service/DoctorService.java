package service;

import dao.DoctorDAO;
import model.Doctor;
import utils.IdDoctorGenerator;
import java.time.LocalDate;

public class DoctorService {
    private final DoctorDAO doctorDAO;

    public DoctorService() {
        this.doctorDAO = new DoctorDAO();
    }

    public void registerDoctor(String name, String lastName, String dui, LocalDate birthdate,
                               LocalDate fechaContratacion, String especialidad) {
        String id = IdDoctorGenerator.IdZaunGenerator();
        Doctor doctor = new Doctor(name, lastName, dui, birthdate, fechaContratacion, especialidad, id);
        doctorDAO.addDoctor(doctor);
    }

    public void showAllDoctors() {
        for (Doctor d : doctorDAO.getAllDoctors()) {
            System.out.println(d.getName() + " " + d.getLastName() + " - " + d.getEspecialidad() + " | ID: " + d.getId());
        }
    }

    public Doctor findDoctorById(String id) {
        return doctorDAO.getDoctorById(id);
    }
}

