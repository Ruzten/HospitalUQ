package co.edu.uniquindio.poo.proyectojavafx.controller;

import co.edu.uniquindio.poo.proyectojavafx.model.HistorialMedico;
import co.edu.uniquindio.poo.proyectojavafx.model.HospitalUQ;
import co.edu.uniquindio.poo.proyectojavafx.model.Medico;
import co.edu.uniquindio.poo.proyectojavafx.model.Paciente;

import java.time.LocalDate;
import java.util.LinkedList;

public class AdminController {
    private static Medico medico;
    public static Paciente paciente;
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

    public static Paciente ActualizarPaciente(String numeroDocumento, String nombre, String apellidos,
                                              LocalDate fechaNacimiento, String telefono, String email, String direccion){
        return hospitalUQ.actualizarPaciente(numeroDocumento, nombre, apellidos, fechaNacimiento, telefono, email, direccion);
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
