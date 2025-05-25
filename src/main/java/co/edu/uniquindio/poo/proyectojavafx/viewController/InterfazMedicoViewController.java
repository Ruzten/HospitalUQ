package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.Genero;
import co.edu.uniquindio.poo.proyectojavafx.model.Medico;
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

    public void inicializarMedico(Medico medico) {
        String titulo = (medico.getGenero() == Genero.FEMENINO) ? "Dra." : "Dr.";
        String apellido = medico.getApellidos().split(" ")[0];
        mensajeBienvenida.setText("¡Bienvenido, " + titulo + " " + apellido + "!");
    }

    @FXML
    public void volverInicio(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectojavafx/InicioApp.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
