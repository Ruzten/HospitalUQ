package co.edu.uniquindio.poo.proyectojavafx.Controller;

import co.edu.uniquindio.poo.proyectojavafx.Model.HistorialMedico;
import co.edu.uniquindio.poo.proyectojavafx.Model.HospitalUQ;
import co.edu.uniquindio.poo.proyectojavafx.Model.Medico;
import co.edu.uniquindio.poo.proyectojavafx.Model.Paciente;

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


}
