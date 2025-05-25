package co.edu.uniquindio.poo.proyectojavafx.Controller;

import co.edu.uniquindio.poo.proyectojavafx.model.HistorialMedico;
import co.edu.uniquindio.poo.proyectojavafx.model.HospitalUQ;
import co.edu.uniquindio.poo.proyectojavafx.model.Medico;
import co.edu.uniquindio.poo.proyectojavafx.model.Paciente;

import java.util.LinkedList;

public class AdminController {
    private static Medico medico;
    private static Paciente paciente;
    private static HospitalUQ hospitalUQ;

    public static Medico buscarMedico(String id){
        return hospitalUQ.buscarMedico(id);
    }

    public static Paciente buscarPaciente(String id){
        return hospitalUQ.buscarPaciente(id);
    }

    public static boolean RegistrarMedico(Medico medico){
        return hospitalUQ.crearMedico(medico);
    }

    public static boolean RegistrarPaciente(Paciente paciente){
        return hospitalUQ.crearPaciente(paciente);
    }

    public static Medico ActualizarMedico(Medico medico){
        return hospitalUQ.ActualizarMedico(medico);
    }

    public static Paciente ActualizarPaciente(Paciente paciente){
        return hospitalUQ.actualizarPaciente(paciente);
    }

    public static boolean eliminarMedico(String id){
        return hospitalUQ.eliminarMedico(id);
    }

    public static boolean eliminarPaciente(String id){
        return hospitalUQ.eliminarPaciente(id);
    }

   public static boolean eliminarMedicoPaciente(String idMedico){
       return hospitalUQ.eliminarMedico(idMedico);
   }

   public static LinkedList<HistorialMedico> obtenerHistorialMedicoPaciente(String idPaciente){
       return hospitalUQ.obtenerHistorialMedicoPaciente(idPaciente);
   }


   public static LinkedList<Paciente> obtenerPacientes(){
       return hospitalUQ.getListaPacientes();
   }




}
