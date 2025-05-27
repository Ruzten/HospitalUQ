package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

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
        Paciente paciente = (Paciente) Sesion.getUsuarioActual();
        System.out.println("Paciente logueado: " + paciente.getNombres());

        txtCedula.setText(paciente.getId());

        txtGenero.setText(paciente.getGenero().toString());
        txtNombres.setText(paciente.getNombres());
        txtApellidos.setText(paciente.getApellidos());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNacimientoStr = paciente.getFechaNacimiento().format(formatter);

        txtfechaNacimiento.setText(fechaNacimientoStr);
        txtTelefono.setText(paciente.getTelefono());
        txtCorreo.setText(paciente.getCorreo());
        txtDireccion.setText(paciente.getDireccion());
        txtTipoSangre.setText(paciente.getRh().toString());
    }
    @FXML
    public void volverAtras(ActionEvent event) throws IOException {
        Navegacion.volver();
    }
    @FXML
    public void IrEditarDatosPersonalesPaciente(ActionEvent event) throws IOException {
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/EditarDatosPersonalesPaciente.fxml");
    }
}
