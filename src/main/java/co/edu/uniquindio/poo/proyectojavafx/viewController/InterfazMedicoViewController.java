package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class InterfazMedicoViewController {
    @FXML
    private Label mensajeBienvenida;

    @FXML
    public void initialize() {
        Persona medico = Sesion.getUsuarioActual();
        String titulo = (medico.getGenero() == Genero.FEMENINO) ? "Dra." : "Dr.";
        String apellido = medico.getApellidos().split(" ")[0];
        mensajeBienvenida.setText("¡Bienvenido, " + titulo + " " + apellido + "!");
    }

    @FXML
    public void cerrarSesion (ActionEvent event) throws IOException {
        Sesion.cerrarSesion();
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/InicioApp.fxml");
        Navegacion.reiniciarHistorial();
    }

    @FXML
    public void irRegistrarMedicoID (ActionEvent event) throws  IOException {
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/Doctor-RegistrarHistorialMedicoID.fxml");
    }

    @FXML
    public void irRegistrarHorarioDisponible (ActionEvent event) throws  IOException {
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/Doctor-RegistrarHorarioDisponible.fxml");
    }

}
