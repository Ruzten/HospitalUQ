package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import java.io.IOException;

public class MisDatosPersonalesPacienteViewController {
    @FXML
    private Text txtCedula;
    @FXML
    private Text txtGenero;
    @FXML
    private Text txtNombres;
    @FXML
    private Text txtApellidos;
    @FXML
    private Text txtfechaNacimiento;
    @FXML
    private Text txtTelefono;
    @FXML
    private Text txtCorreo;
    @FXML
    private Text txtDireccion;
    @FXML
    private Text txtTipoSangre;

    @FXML
    public void initialize() {
        Persona paciente = Sesion.getUsuarioActual();
        System.out.println("Paciente logueado: " + paciente.getNombres());
        txtCedula.setText(paciente.getId());
    }
    @FXML
    public void VolverInterfazPaciente(ActionEvent event) throws IOException {
        Navegacion.volver();
    }
    @FXML
    public void IrEditarDatosPersonalesPaciente(ActionEvent event) throws IOException {
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/MisDatosPersonales.fxml");
    }
}
