package co.edu.uniquindio.poo.proyectojavafx.controller;

import co.edu.uniquindio.poo.proyectojavafx.model.HistorialMedico;
import co.edu.uniquindio.poo.proyectojavafx.model.HospitalUQ;
import co.edu.uniquindio.poo.proyectojavafx.model.Paciente;

import java.util.List;

public class PacienteController {
    private static HospitalUQ hospitalUQ;
    private static Paciente paciente;

    public static boolean registrarPaciente(){
        return hospitalUQ.crearPaciente(paciente);
    }

    public static Paciente actualizarPaciente(){
        return hospitalUQ.actualizarPaciente(paciente);
    }

    public static boolean eliminarPaciente(){
        return hospitalUQ.eliminarPaciente(paciente.getId());
    }

    public static List<HistorialMedico> obtenerHistorialMedicoPaciente(){
        return hospitalUQ.obtenerHistorialMedicoPaciente(paciente.getId());
    }



}
