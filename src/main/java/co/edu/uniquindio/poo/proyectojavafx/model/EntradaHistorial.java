package co.edu.uniquindio.poo.proyectojavafx.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EntradaHistorial {
    private String id;
    private LocalDateTime fecha;
    private String diagnostico;
    private String tratamiento;
    private Medico medico;
    private List<String> archivosAdjuntos;
    private String notasAdicionales;

    public EntradaHistorial(String id, String diagnostico, String tratamiento,
                            Medico medico, LocalDateTime fecha) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.medico = medico;
        this.fecha = fecha;
        this.archivosAdjuntos = new ArrayList<>();
        this.notasAdicionales = "";
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    // Métodos adicionales
    public void agregarArchivoAdjunto(String rutaArchivo) {
        archivosAdjuntos.add(rutaArchivo);
    }

    public void eliminarArchivoAdjunto(String rutaArchivo) {
        archivosAdjuntos.remove(rutaArchivo);
    }

}