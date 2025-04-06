package dao;

import model.Cita;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {
    private static final List<Cita> citas = new ArrayList<>();

    public void addCita(Cita cita) {
        citas.add(cita);
    }

    public List<Cita> getAllCitas() {
        return citas;
    }

    public void removeCita(Cita cita) {
        citas.remove(cita);
    }
}

