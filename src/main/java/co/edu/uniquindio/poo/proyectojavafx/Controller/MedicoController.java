package co.edu.uniquindio.poo.proyectojavafx.controller;

import co.edu.uniquindio.poo.proyectojavafx.model.HistorialMedico;
import co.edu.uniquindio.poo.proyectojavafx.model.HospitalUQ;
import co.edu.uniquindio.poo.proyectojavafx.model.Medico;
import co.edu.uniquindio.poo.proyectojavafx.model.Paciente;

import java.time.LocalDate;
import java.util.List;

public class MedicoController {
    private static Medico medico;
    private static HospitalUQ hospitalUQ;


   public static Paciente buscarPaciente(String id){
       return hospitalUQ.buscarPaciente(id);
   }

   public static boolean agregarHistorialMedico(String idPaciente, HistorialMedico historialMedico){
        return hospitalUQ.agregarHistorialMedico(idPaciente, historialMedico);
   }

   public static boolean actualizarHistorialMedico(String idPaciente, HistorialMedico historialMedico){
       return hospitalUQ.actualizarHistorialMedico(idPaciente, historialMedico);
   }

   public static List<HistorialMedico> obtenerHistorialMedicoPaciente(String idPaciente){
        return hospitalUQ.obtenerHistorialMedicoPaciente(idPaciente);
   }

  public static List<Paciente> obtenerPacientes(){
        return hospitalUQ.obtenerPacientes();
  }

  public static Paciente actualizarPaciente(String numeroDocumento, String nombre, String apellidos,
                                            LocalDate fechaNacimiento, String telefono, String email){
        return hospitalUQ.actualizarPaciente(numeroDocumento, nombre, apellidos, fechaNacimiento, telefono, email);
  }

  public static Medico actualizarMedico(Medico medico){
        return hospitalUQ.ActualizarMedico(medico);
  }

  public static boolean eliminarMedico(String id){
        return hospitalUQ.eliminarMedico(id);
  }

  public static Medico buscarMedico(String id){
        return hospitalUQ.buscarMedico(id);
  }


}
