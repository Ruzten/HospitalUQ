package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.controller.PacienteController;
import co.edu.uniquindio.poo.proyectojavafx.model.Navegacion;
import co.edu.uniquindio.poo.proyectojavafx.model.Paciente;
import co.edu.uniquindio.poo.proyectojavafx.model.Sesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.time.LocalDate;

public class EditarDatosPersonalesPacienteViewController {
    Paciente paciente = (Paciente) Sesion.getUsuarioActual();
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private DatePicker dateFechaNacimiento;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtDireccion;

    @FXML
    public void initialize() {
        txtNombres.setText(paciente.getNombres());
        txtApellidos.setText(paciente.getApellidos());
        dateFechaNacimiento.setValue(paciente.getFechaNacimiento());
        txtTelefono.setText(paciente.getTelefono());
        txtCorreo.setText(paciente.getCorreo());
        txtDireccion.setText(paciente.getDireccion());
    }

    @FXML
    public void volverAtras() {
        Navegacion.volver();
    }

    @FXML
    private void confirmar(ActionEvent event) throws IOException {
        String nombre = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        LocalDate fechaNacimiento = dateFechaNacimiento.getValue();
        String telefono = txtTelefono.getText();
        String email = txtCorreo.getText();
        String direccion = txtDireccion.getText();
        PacienteController.actualizarPaciente(numeroDocumento, nombre, apellidos, fechaNacimiento, telefono, email));
        mostrarAlerta("Datos cambiados exitosamente!");
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/InterfazPaciente.fxml");
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registro");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}



