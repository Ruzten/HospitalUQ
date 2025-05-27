package co.edu.uniquindio.poo.proyectojavafx.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReporteServicio {
    public List<Cita> obtenerCitasPorMedico (List<Cita> citas, Medico medico){
        return citas.stream()
                .filter(cita -> cita.getMedico().equals(medico))
                .collect(Collectors.toList());
    }

    public List<Cita> obtenerCitasPorDia (List<Cita> citas, LocalDate fecha){
        return citas.stream()
                .filter(cita -> cita.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }
}
