package co.edu.uniquindio.poo.proyectojavafx.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Persona {
    private LocalDate fechaNacimiento;
    private TipoSangre rh;
    private List<HistorialMedico> historialMedico;

    public Paciente(String id, Genero genero, String nombres, String apellidos, int edad, String telefono, String correo, String direccion, String contrasena, LocalDate fechaNacimiento, TipoSangre rh) {
        super(id, genero, nombres, apellidos, edad, telefono, correo, direccion, contrasena);
        this.fechaNacimiento = fechaNacimiento;
        this.rh = rh;
        this.historialMedico = new ArrayList<>();
    }

    public Paciente(String id, Genero genero, String nombres, String apellidos, int edad, String correo, String direccion, TipoSangre rh, String contrasena, LocalDate fechaNacimiento) {
        super();
    }


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // ... (continuar con los demás getters y setters)

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

    public void calcularYAsignarEdad() {
        if (fechaNacimiento != null) {
            int edadCalculada = Period.between(fechaNacimiento, LocalDate.now()).getYears();
            setEdad(edadCalculada);
        }
    }

}