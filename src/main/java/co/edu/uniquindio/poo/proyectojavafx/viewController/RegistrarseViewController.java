package co.edu.uniquindio.poo.proyectojavafx.viewController;
import co.edu.uniquindio.poo.proyectojavafx.controller.RegistrarseController;
import co.edu.uniquindio.poo.proyectojavafx.model.Genero;
import co.edu.uniquindio.poo.proyectojavafx.model.Navegacion;
import co.edu.uniquindio.poo.proyectojavafx.model.TipoSangre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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
        Navegacion.volver();
    }

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
        registrarseController.registrarseUsuario(id.getText(), genero.getValue(), nombres.getText(), apellidos.getText(), numeroTelefonico.getText(), correo.getText(), direccion.getText(), rh.getValue(), contrasena.getText(), fechaNacimiento.getValue())
        ;
    }

}
