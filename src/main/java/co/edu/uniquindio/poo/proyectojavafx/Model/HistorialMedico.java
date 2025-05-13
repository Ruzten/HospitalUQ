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

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Medico getMedicoTratante() {
        return medicoTratante;
    }

    public void setMedicoTratante(Medico medicoTratante) {
        this.medicoTratante = medicoTratante;
    }
}
