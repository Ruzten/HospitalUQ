package co.edu.uniquindio.poo.proyectojavafx.model;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Persona {
    private String fechaNacimiento;
    private TipoSangre rh;
    private List<HistorialMedico> historialMedico;

    public Paciente(String id, Genero genero, String nombres, String apellidos, int edad, String telefono, String correo, String direccion, String contrasena, String fechaNacimiento, TipoSangre rh) {
        super(id, genero, nombres, apellidos, edad, telefono, correo, direccion, contrasena);
        this.fechaNacimiento = fechaNacimiento;
        this.rh = rh;
        this.historialMedico = new ArrayList<>();
    }


    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public void agregarHistorialMedico(HistorialMedico historial) {
        this.historialMedico.add(historial);
    }

    public List<HistorialMedico> getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(List<HistorialMedico> historialMedico) {
        this.historialMedico = historialMedico;
    }

    public TipoSangre getRh() {
        return rh;
    }

    public void setRh(TipoSangre rh) {
        this.rh = rh;
    }

}