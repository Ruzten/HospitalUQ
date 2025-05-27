package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.controller.RegistrarseController;
import co.edu.uniquindio.poo.proyectojavafx.model.HospitalUQ;
import co.edu.uniquindio.poo.proyectojavafx.model.Navegacion;
import co.edu.uniquindio.poo.proyectojavafx.model.Paciente;
import co.edu.uniquindio.poo.proyectojavafx.model.SesionTemporal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DoctorRegistrarHistorialMedicoIDViewController {
    HospitalUQ hospitalUQ = HospitalUQ.getInstancia();
    @FXML
    public void volverAtras(ActionEvent event) throws IOException {
        Navegacion.volver();
    }
    @FXML
    private TextField txtIdPaciente;
    @FXML
    private void confirmar(ActionEvent event) throws IOException {
        String id = txtIdPaciente.getText();
        Paciente paciente = hospitalUQ.buscarPaciente(id);
        if (paciente == null) {
            mostrarAlerta("El paciente no existe en la base de datos");
        }
        else {
            SesionTemporal.setPersonaSeleccionada(paciente);
            Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/Doctor-RegistrarHistorialMedico.fxml");
        }
    }
    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registro");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
