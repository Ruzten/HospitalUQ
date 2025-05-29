package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.Navegacion;
import co.edu.uniquindio.poo.proyectojavafx.model.Persona;
import co.edu.uniquindio.poo.proyectojavafx.model.Sesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;

public class InterfazPacienteViewController {
    @FXML
    private Label mensajeBienvenida;

    @FXML
    public void initialize() {
        Persona paciente = Sesion.getUsuarioActual();
        mensajeBienvenida.setText("¡Bienvenido, " + paciente.getNombres() + "!");
    }

    @FXML
    public void IrAMisDatosPersonales(ActionEvent event) throws IOException {
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/MisDatosPersonalesPaciente.fxml");
    }
    @FXML
    public void IrHistorialMedico(ActionEvent event) throws IOException {
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/Paciente-HistorialMedico.fxml");
    }
    @FXML
    public void IrCitasMedicas(ActionEvent event) throws IOException {
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/Paciente-CitasMedicas.fxml");
    }
    @FXML
    public void IrAgendarCitaMedica(ActionEvent event) throws IOException {
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/Paciente-AgendarCitaMedica.fxml");
    }
    @FXML
    public void cerrarSesion (ActionEvent event) throws IOException {
        Sesion.cerrarSesion();
        Navegacion.cambiarVista("/co/edu/uniquindio/poo/proyectojavafx/InicioApp.fxml");
        Navegacion.reiniciarHistorial();
    }
}
