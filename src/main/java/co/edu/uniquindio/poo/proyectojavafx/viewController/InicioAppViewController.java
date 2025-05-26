package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.Navegacion;
import javafx.event.ActionEvent;
import java.io.IOException;

public class InicioAppViewController {
    public void AbrirLogin(ActionEvent event) throws IOException {
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/Login.fxml");
    }
    public void AbrirRegistrarse(ActionEvent event) throws IOException {
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/Registrarse.fxml");
    }
}