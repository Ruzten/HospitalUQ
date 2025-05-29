package co.edu.uniquindio.poo.proyectojavafx.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Medico extends Persona {
    private String NLicencia;
    private boolean certificado;
    private List<Horario> horarios;
    private String ubicacion;
    private Estado estado;
    private Especialidad especialidad;
    private List<Cita> citasAsignadas;
    private List<HistorialMedico> historialesPacientes;

    public Medico(String id, Genero genero, String nombres, String apellidos, int edad, String telefono, String correo, String direccion, String contrasena, String NLicencia, boolean certificado, List<Horario> horarios, String ubicacion, Estado estado, Especialidad especialidad, List<Cita> citasAsignadas, List<HistorialMedico> historialesPacientes) {
        super(id, genero, nombres, apellidos, edad, telefono, correo, direccion, contrasena);
        this.NLicencia = NLicencia;
        this.certificado = certificado;
        this.horarios = horarios;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.especialidad = especialidad;
        this.citasAsignadas = citasAsignadas;
        this.historialesPacientes = historialesPacientes;
    }

    public List<Cita> getCitasAsignadas() {
        return citasAsignadas;
    }

    public List<HistorialMedico> getHistorialesPacientes() {
        return historialesPacientes;
    }

    // Métodos para gestión de horarios
    public void agregarHorario(Horario horario) {
        if (!horarios.contains(horario)) {
            horarios.add(horario);
        }
    }

    public void eliminarHorario(Horario horario) {
        horarios.remove(horario);
    }

    // Métodos para gestión de citas
    public void agregarCita(Cita cita) {
        citasAsignadas.add(cita);
    }

    public void cancelarCita(Cita cita) {
        citasAsignadas.remove(cita);
    }

    public boolean tieneDisponibilidad(Horario horario) {
        return horarios.stream()
                .anyMatch(h -> !h.estaOcupado() && h.coincideCon(horario));
    }



    public boolean agregarHistorialPaciente(String id, Paciente paciente, String grupoSanguineo,
                                         List<String> alergias, List<String> antecedentes, String diagnostico,
                                         String tratamiento, Medico medico, List<String> archivosAdjuntos, String notasAdicionales) {

        HistorialMedico historial = new HistorialMedico(
                id,
                paciente,
                grupoSanguineo,
                alergias,
                antecedentes,
                LocalDate.now(), // fechaCreacion
                LocalDateTime.now(), // fecha
                diagnostico,
                tratamiento,
                medico,
                archivosAdjuntos != null ? archivosAdjuntos : new ArrayList<>(),
                notasAdicionales
        );

        historialesPacientes.add(historial);
        return  true;
    }

    public void registrarDiagnostico(HistorialMedico historial, String diagnostico,
                                     String tratamiento, Medico medico, List<String> archivosAdjuntos, String notasAdicionales) {

        if (historialesPacientes.contains(historial)) {
            historial.setDiagnostico(diagnostico);
            historial.setTratamiento(tratamiento);
            historial.setMedico(medico);
            historial.setFecha(LocalDateTime.now());

            if (archivosAdjuntos != null && !archivosAdjuntos.isEmpty()) {
                historial.setArchivosAdjuntos(archivosAdjuntos);
            }

            if (notasAdicionales != null && !notasAdicionales.trim().isEmpty()) {
                historial.setNotasAdicionales(notasAdicionales);
            }
        }
    }



    public String getNLicencia() {
        return NLicencia;
    }

    public void setNLicencia(String NLicencia) {
        this.NLicencia = NLicencia;
    }

    public boolean getCertificado() {
        return certificado;
    }

    public boolean isCertificado() {
        return certificado;
    }

    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public void setCitasAsignadas(List<Cita> citasAsignadas) {
        this.citasAsignadas = citasAsignadas;
    }

    public void setHistorialesPacientes(List<HistorialMedico> historialesPacientes) {
        this.historialesPacientes = historialesPacientes;
    }

    @Override
    public String toString() {
        String prefijo;
        if (this.getGenero() == Genero.MASCULINO) {
            prefijo = "Dr. ";
        } else {
            prefijo = "Dra. ";
        }
        return prefijo + getNombres() + " " + getApellidos();
    }


}