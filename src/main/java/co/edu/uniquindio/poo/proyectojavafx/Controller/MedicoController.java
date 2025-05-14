package co.edu.uniquindio.poo.proyectojavafx.Controller;

import co.edu.uniquindio.poo.proyectojavafx.Model.HospitalUQ;
import co.edu.uniquindio.poo.proyectojavafx.Model.Medico;

public class MedicoController {
    HospitalUQ hospitalUQ;

    public MedicoController(HospitalUQ hospitalUQ) {
        this.hospitalUQ = hospitalUQ;
    }

    public boolean AgregarMedico(Medico medico) {
     return hospitalUQ.crearMedico(medico);
    }

}
