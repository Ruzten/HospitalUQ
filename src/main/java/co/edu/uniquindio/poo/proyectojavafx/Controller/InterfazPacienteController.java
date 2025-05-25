package co.edu.uniquindio.poo.proyectojavafx.Controller;

import co.edu.uniquindio.poo.proyectojavafx.model.Paciente;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InterfazPacienteController {
    @FXML
    private Label lblBienvenida;

    public void bienvenidaPaciente(Paciente paciente) {
        lblBienvenida.setText("¡Bienvenido, " + paciente.getNombres() + " " + paciente.getApellidos() + "!");
    }

}
