package co.edu.uniquindio.poo.proyectojavafx.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class GestorCitas {
    private List<Cita> citasProgramadas;

    public GestorCitas() {
        this.citasProgramadas = new ArrayList<>();
    }

    // agendar una cita
    public boolean agendarCita (String id, Paciente paciente, Medico medico, LocalDateTime fecha, Horario horario, String motivo, EstadoCita estado, String observaciones ) {
        Cita cita = new Cita(id, paciente, medico, fecha, horario, motivo);
        boolean anadida = citasProgramadas.add(cita);
        return anadida;

    }

    // Cancelar cita por ID de cita
    public boolean cancelarCita(String id) {
        boolean encontrada = citasProgramadas.removeIf(cita -> cita.getId().equals(id));
        return encontrada;
    }

    //Reprogramar una cita por ID
    public boolean reprogramarCita(String id, LocalDateTime nuevafecha) {
        for(Cita cita : citasProgramadas){
            if(cita.getId().equals(id)){
                cita.setFecha(nuevafecha);
                return true;
            }
        }
        return false;
    }
    // Ver todas las citas programadas
    public Optional<List<Cita>> verCitasProgramadas(){
        if(citasProgramadas.isEmpty()){
            return Optional.empty();
        }else {
            return Optional.of(new ArrayList<>(citasProgramadas));
        }
    }


}