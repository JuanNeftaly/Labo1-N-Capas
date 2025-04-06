package dao;

import model.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    private static final List<Doctor> doctores = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctores.add(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctores;
    }

    public Doctor getDoctorById(String id) {
        for (Doctor d : doctores) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }
}

