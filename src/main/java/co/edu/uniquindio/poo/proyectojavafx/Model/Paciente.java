package co.edu.uniquindio.poo.proyectojavafx.Model;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Persona {
    private String fechaNacimiento;
    private TipoSangre rh;
    private List<HistorialMedico> historialMedico;

    public Paciente(String id, Genero genero, String nombres, String apellidos, int edad, String telefono, String correo, String direccion, String contraseña, String fechaNacimiento, TipoSangre rh) {
        super(id, genero, nombres, apellidos, edad, telefono, correo, direccion, contraseña);
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

    // ... (continuar con los demás getters y setters)

    public void agregarHistorialMedico(HistorialMedico historial) {
        this.historialMedico.add(historial);
    }
}