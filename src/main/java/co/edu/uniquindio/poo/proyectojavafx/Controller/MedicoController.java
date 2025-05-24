package co.edu.uniquindio.poo.proyectojavafx.controller;

import co.edu.uniquindio.poo.proyectojavafx.model.HistorialMedico;
import co.edu.uniquindio.poo.proyectojavafx.model.HospitalUQ;
import co.edu.uniquindio.poo.proyectojavafx.model.Medico;
import co.edu.uniquindio.poo.proyectojavafx.model.Paciente;

import java.util.List;

public class MedicoController {
    private Medico medico;
    private HospitalUQ hospitalUQ;

    public MedicoController(HospitalUQ hospitalUQ, Medico medicoActual) {
        this.hospitalUQ = hospitalUQ;
        this.medico = medicoActual;
    }

   public Paciente buscarPaciente(String id){
       return hospitalUQ.buscarPaciente(id);
   }

   public boolean agregarHistorialMedico(String idPaciente, HistorialMedico historialMedico){
        return hospitalUQ.agregarHistorialMedico(idPaciente, historialMedico);
   }

   public boolean actualizarHistorialMedico(String idPaciente, HistorialMedico historialMedico){
       return hospitalUQ.ActualizarHistorialMedico(idPaciente, historialMedico);
   }

   public List<HistorialMedico> obtenerHistorialMedicoPaciente(String idPaciente){
        return hospitalUQ.obtenerHistorialMedicoPaciente(idPaciente);
   }

  public List<Paciente> obtenerPacientes(){
        return hospitalUQ.obtenerPacientes();
  }

  public Paciente actualizarPaciente(Paciente paciente){
        return hospitalUQ.actualizarPaciente(paciente);
  }

  public Medico actualizarMedico(Medico medico){
        return hospitalUQ.ActualizarMedico(medico);
  }

  public boolean eliminarMedico(String id){
        return hospitalUQ.eliminarMedico(id);
  }

  public Medico buscarMedico(String id){
        return hospitalUQ.buscarMedico(id);
  }


}
