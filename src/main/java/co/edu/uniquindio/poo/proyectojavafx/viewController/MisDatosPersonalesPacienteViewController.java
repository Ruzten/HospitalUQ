package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MisDatosPersonalesPacienteViewController {



    @FXML
    public void initialize() {
        Persona paciente = Sesion.getUsuarioActual();
        System.out.println("Paciente logueado: " + paciente.getNombres());
        txtCedula.setText(paciente.getId());
    }
    @FXML
    public void VolverInterfazPaciente(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectojavafx/InterfazPaciente.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void IrEditarDatosPersonalesPaciente(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectojavafx/EditarDatosPersonalesPaciente.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

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

}
