package co.edu.uniquindio.poo.proyectojavafx.Controller;

import co.edu.uniquindio.poo.proyectojavafx.model.HistorialMedico;
import co.edu.uniquindio.poo.proyectojavafx.model.HospitalUQ;
import co.edu.uniquindio.poo.proyectojavafx.model.Paciente;

import java.util.List;

public class PacienteController {
    private static Paciente paciente;
    private static HospitalUQ hospitalUQ;

    public static void inicializar(Paciente pacienteParams, HospitalUQ hospitalUQParams) {
        paciente = pacienteParams;
        hospitalUQ = hospitalUQParams;
    }

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
