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
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LoginViewController {
    @FXML
    public void VolverInicio(ActionEvent event) throws IOException {
        Navegacion.volver();
    }
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContrasena;
    @FXML
    private Text textoError;
    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException {
        String id = txtUsuario.getText();
        String clave = txtContrasena.getText();

        Object usuarioValido = HospitalUQ.buscarUsuario(id, clave);


        if (usuarioValido != null) {

            if (usuarioValido instanceof Paciente paciente) {
                textoError.setVisible(true);
                Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/InterfazPaciente.fxml");
                Sesion.setUsuarioActual(paciente);

            } else if (usuarioValido instanceof Medico medico) {
                textoError.setVisible(true);
                Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/InterfazDoctor.fxml");
                Sesion.setUsuarioActual(medico);
            } else if (usuarioValido instanceof Administrador admin) {
                textoError.setVisible(true);
                Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/InterfazAdmin.fxml");
                Sesion.setUsuarioActual(admin);
            }
        }
        else {
            textoError.setVisible(true);
            textoError.setText("Usuario o contraseña incorrectos");
        }
    }

}
