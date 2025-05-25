package co.edu.uniquindio.poo.proyectojavafx.Controller;

import co.edu.uniquindio.poo.proyectojavafx.model.HistorialMedico;
import co.edu.uniquindio.poo.proyectojavafx.model.HospitalUQ;
import co.edu.uniquindio.poo.proyectojavafx.model.Medico;
import co.edu.uniquindio.poo.proyectojavafx.model.Paciente;

import java.util.List;

public class MedicoController {
    private static Medico medico;
    private static HospitalUQ hospitalUQ;

    public MedicoController(HospitalUQ hospitalUQParams, Medico medicoActual) {
        hospitalUQ = hospitalUQParams;
        medico = medicoActual;
    }

   public static Paciente buscarPaciente(String id){
       return hospitalUQ.buscarPaciente(id);
   }

   public static boolean agregarHistorialMedico(String idPaciente, HistorialMedico historialMedico){
        return hospitalUQ.agregarHistorialMedico(idPaciente, historialMedico);
   }

   public static boolean actualizarHistorialMedico(String idPaciente, HistorialMedico historialMedico){
       return hospitalUQ.ActualizarHistorialMedico(idPaciente, historialMedico);
   }

   public static List<HistorialMedico> obtenerHistorialMedicoPaciente(String idPaciente){
        return hospitalUQ.obtenerHistorialMedicoPaciente(idPaciente);
   }

  public static List<Paciente> obtenerPacientes(){
        return hospitalUQ.obtenerPacientes();
  }

  public static Paciente actualizarPaciente(Paciente paciente){
        return hospitalUQ.actualizarPaciente(paciente);
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
