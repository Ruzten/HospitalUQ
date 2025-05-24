package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.Genero;
import co.edu.uniquindio.poo.proyectojavafx.model.Medico;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InterfazMedicoViewController {
    @FXML
    private Label mensajeBienvenida;

    public void inicializarMedico(Medico medico) {
        String titulo = (medico.getGenero() == Genero.FEMENINO) ? "Dra." : "Dr.";
        String apellido = medico.getApellidos().split(" ")[0];
        mensajeBienvenida.setText("¡Bienvenido, " + titulo + " " + apellido + "!");
    }
}
