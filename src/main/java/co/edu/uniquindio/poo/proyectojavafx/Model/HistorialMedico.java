package co.edu.uniquindio.poo.proyectojavafx.Model;
import java.time.LocalDate;


public class HistorialMedico {

    private LocalDate fecha;
    private String diagnostico;
    private String tratamiento;
    private String observaciones;
    private Medico medicoTratante;

    public HistorialMedico(LocalDate fecha, String diagnostico, String tratamiento, String observaciones, Medico medicoTratante) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.medicoTratante = medicoTratante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
