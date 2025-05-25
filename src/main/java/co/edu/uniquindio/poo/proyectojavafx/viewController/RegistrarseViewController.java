package co.edu.uniquindio.poo.proyectojavafx.viewController;
import co.edu.uniquindio.poo.proyectojavafx.controller.RegistrarseController;
import co.edu.uniquindio.poo.proyectojavafx.model.Genero;
import co.edu.uniquindio.poo.proyectojavafx.model.TipoSangre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrarseViewController {
    private final RegistrarseController registrarseController = new RegistrarseController();

    @FXML
    public void initialize() {
        genero.getItems().setAll(Genero.values());
        rh.getItems().setAll(TipoSangre.values());
    }



    @FXML
    public void volverInicio(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectojavafx/InicioApp.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    // RECOLECCION DE DATOS PARA REGISTRARSE

    @FXML
    private ChoiceBox<Genero> genero;
    @FXML
    private TextField nombres;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField numeroTelefonico;
    @FXML
    private TextField id;
    @FXML
    private TextField correo;
    @FXML
    private TextField direccion;
    @FXML
    private ChoiceBox<TipoSangre> rh;
    @FXML
    private TextField contrasena;
    @FXML
    private DatePicker fechaNacimiento;

    public void registrarse () {
        registrarseController.registrarseUsuario(id.getText(), genero.getValue(), nombres.getText(), apellidos.getText(), numeroTelefonico.getText(), correo.getText(), direccion.getText(), rh.getValue(), contrasena.getText(), fechaNacimiento.getValue());
    }

}
