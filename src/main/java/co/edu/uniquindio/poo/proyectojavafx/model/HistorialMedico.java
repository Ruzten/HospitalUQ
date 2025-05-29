package co.edu.uniquindio.poo.proyectojavafx.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class HistorialMedico {
    private String id;
    private Paciente paciente;
    private String grupoSanguineo;
    private List<String> alergias;
    private LocalDate fechaCreacion;
    private LocalDateTime fecha;
    private String diagnostico;
    private String tratamiento;
    private Medico medico;
    private List<String> archivosAdjuntos;
    private String notasAdicionales;

    public HistorialMedico(String id, Paciente paciente, String grupoSanguineo, List<String> alergias,  LocalDate fechaCreacion, LocalDateTime fecha, String diagnostico, String tratamiento, Medico medico, List<String> archivosAdjuntos, String notasAdicionales) {
        this.id = id;
        this.paciente = paciente;
        this.grupoSanguineo = grupoSanguineo;
        this.alergias = alergias;
        this.fechaCreacion = fechaCreacion;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.medico = medico;
        this.archivosAdjuntos = archivosAdjuntos;
        this.notasAdicionales = notasAdicionales;
    }

    // Getters y Setters básicos
    public String getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<String> getArchivosAdjuntos() {
        return archivosAdjuntos;
    }

    public void setArchivosAdjuntos(List<String> archivosAdjuntos) {
        this.archivosAdjuntos = archivosAdjuntos;
    }

    public String getNotasAdicionales() {
        return notasAdicionales;
    }

    public void setNotasAdicionales(String notasAdicionales) {
        this.notasAdicionales = notasAdicionales;
    }

    public void agregarArchivoAdjunto(String rutaArchivo) {
        archivosAdjuntos.add(rutaArchivo);
    }

    public void eliminarArchivoAdjunto(String rutaArchivo) {
        archivosAdjuntos.remove(rutaArchivo);
    }
}
