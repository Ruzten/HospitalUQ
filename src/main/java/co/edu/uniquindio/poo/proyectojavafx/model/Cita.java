package co.edu.uniquindio.poo.proyectojavafx.model;

import java.time.LocalDateTime;

public class Cita {
    private String id;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime fecha;
    private Horario horario;
    private String motivo;
    private EstadoCita estado;
    private String observaciones;



    public Cita(String id, Paciente paciente, Medico medico, LocalDateTime fecha,
                Horario horario, String motivo) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.horario = horario;
        this.motivo = motivo;
        this.estado = EstadoCita.PROGRAMADA;
        this.observaciones = "";
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    // Métodos adicionales
    public void confirmarCita() {
        this.estado = EstadoCita.CONFIRMADA;
    }

    public void completarCita() {
        this.estado = EstadoCita.COMPLETADA;
    }

    public void cancelarCita() {
        this.estado = EstadoCita.CANCELADA;
    }

    public void registrarInasistencia() {
        this.estado = EstadoCita.NO_ASISTIO;
    }

}