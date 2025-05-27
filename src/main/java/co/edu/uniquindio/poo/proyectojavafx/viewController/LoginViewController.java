package co.edu.uniquindio.poo.proyectojavafx.viewController;
import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LoginViewController {
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContrasena;
    @FXML
    private Text textoError;

    @FXML
    public void VolverInicio(ActionEvent event) throws IOException {
        Navegacion.volver();
    }

    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException {
        String id = txtUsuario.getText();
        String clave = txtContrasena.getText();

        Object usuarioValido = HospitalUQ.buscarUsuario(id, clave);

        if (usuarioValido != null) {

            if (usuarioValido instanceof Paciente paciente) {
                textoError.setVisible(false);
                Sesion.setUsuarioActual(paciente);
                Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/InterfazPaciente.fxml");

            } else if (usuarioValido instanceof Medico medico) {
                textoError.setVisible(false);
                Sesion.setUsuarioActual(medico);
                Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/InterfazDoctor.fxml");
            } else if (usuarioValido instanceof Administrador admin) {
                textoError.setVisible(false);
                Sesion.setUsuarioActual(admin);
                Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/InterfazAdmin.fxml");
            }
        }
        else {
            textoError.setVisible(true);
            textoError.setText("Usuario o contraseña incorrectos");
        }
    }
}
