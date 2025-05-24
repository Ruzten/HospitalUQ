package co.edu.uniquindio.poo.proyectojavafx.model;

import java.util.List;

public class Medico extends Persona {
    private String NLicencia;
    private boolean certificado;
    private List<Horario> horarios;
    private String ubicacion;
    private Estado estado;
    private Especialidad especialidad;

    public Medico(String id, Genero genero, String nombres, String apellidos, int edad, String telefono, String correo, String direccion, String contrasena, String NuLicencia, boolean certificado, List<Horario> horarios, String ubicacion, Estado estado, Especialidad especialidad) {
        super(id, genero, nombres, apellidos, edad, telefono, correo, direccion, contrasena);
        this.NLicencia = NuLicencia;
        this.certificado = certificado;
        this.horarios = horarios;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.especialidad = especialidad;
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

}