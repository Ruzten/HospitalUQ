package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.Navegacion;
import co.edu.uniquindio.poo.proyectojavafx.model.Sesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class InterfazAdminViewController {
    @FXML
    public void cerrarSesion (ActionEvent event) throws IOException {
        Sesion.cerrarSesion();
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/InicioApp.fxml");
        Navegacion.reiniciarHistorial();
    }
}

