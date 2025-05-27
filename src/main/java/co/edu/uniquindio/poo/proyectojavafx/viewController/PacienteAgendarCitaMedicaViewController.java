package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalTime;

public class PacienteAgendarCitaMedicaViewController {
    private Paciente pacienteActual = (Paciente) Sesion.getUsuarioActual();
    @FXML
    private ComboBox<Especialidad> comboEspecialidad;
    @FXML
    private ComboBox<Medico> comboMedico; // ComboBox para objetos Medico
    @FXML
    private DatePicker dateFecha;
    @FXML
    private ComboBox<LocalTime> comboHora; // ComboBox para objetos LocalTime
    @FXML
    private Text mensajeBueno;
    @FXML
    private Text mensajeMalo;

    @FXML
    public void volverAtras(ActionEvent event) throws IOException {
        Navegacion.volver();
    }
}
