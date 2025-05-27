package co.edu.uniquindio.poo.proyectojavafx.controller;

import co.edu.uniquindio.poo.proyectojavafx.model.HistorialMedico;
import co.edu.uniquindio.poo.proyectojavafx.model.HospitalUQ;
import co.edu.uniquindio.poo.proyectojavafx.model.Paciente;
import co.edu.uniquindio.poo.proyectojavafx.model.Sesion;

import java.time.LocalDate;
import java.util.List;

public class PacienteController {
    static HospitalUQ hospitalUQ = HospitalUQ.getInstancia();
    static Paciente paciente = (Paciente) Sesion.getUsuarioActual();

    public static boolean registrarPaciente(){
        return hospitalUQ.crearPaciente(paciente);
    }

    public static Paciente actualizarPaciente(String numeroDocumento, String nombre, String apellidos,
                                              LocalDate fechaNacimiento, String telefono, String email){
        return hospitalUQ.actualizarPaciente(numeroDocumento, nombre, apellidos, fechaNacimiento, telefono, email);
    }

    public static boolean eliminarPaciente(){
        return hospitalUQ.eliminarPaciente(paciente.getId());
    }

    public static List<HistorialMedico> obtenerHistorialMedicoPaciente(){
        return hospitalUQ.obtenerHistorialMedicoPaciente(paciente.getId());
    }

}
