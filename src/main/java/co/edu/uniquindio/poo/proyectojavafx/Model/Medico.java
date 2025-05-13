package co.edu.uniquindio.poo.proyectojavafx.Model;

import java.util.List;

public class Medico extends Persona {
    private String matriculaLicencia;
    private boolean certificado;
    private List<Horario> horarios;
    private String ubicacion;
    private Estado estado;
    private Especialidad especialidad;

    public Medico(String id, Genero genero, String nombres, String apellidos, int edad, String telefono, String correo, String direccion, String contraseña, String matriculaLicencia, boolean certificado, List<Horario> horarios, String ubicacion, Estado estado, Especialidad especialidad) {
        super(id, genero, nombres, apellidos, edad, telefono, correo, direccion, contraseña);
        this.matriculaLicencia = matriculaLicencia;
        this.certificado = certificado;
        this.horarios = horarios;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.especialidad = especialidad;
    }

    public String getMatriculaLicencia() {
        return matriculaLicencia;
    }

    public void setMatriculaLicencia(String matriculaLicencia) {
        this.matriculaLicencia = matriculaLicencia;
    }

    // ... (continuar con los demás getters y setters)
}