package co.edu.uniquindio.poo.proyectojavafx.Controller;

import co.edu.uniquindio.poo.proyectojavafx.model.*;
import co.edu.uniquindio.poo.proyectojavafx.viewController.RegistrarseViewController;
import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrarseController {
    HospitalUQ hospitalUQ = HospitalUQ.getInstancia();

    public void registrarseUsuario(
            String id,
            Genero genero,
            String nombres,
            String apellidos,
            String numeroTelefonico,
            String correo,
            String direccion,
            TipoSangre rh,
            String contrasena,
            LocalDate fechaNacimiento) {

        if (genero == null ||
                id == null || id.trim().isEmpty() ||
                nombres == null || nombres.trim().isEmpty() ||
                apellidos == null || apellidos.trim().isEmpty() ||
                numeroTelefonico == null || numeroTelefonico.trim().isEmpty() ||
                correo == null || correo.trim().isEmpty() ||
                direccion == null || direccion.trim().isEmpty() ||
                rh == null ||
                contrasena == null || contrasena.isEmpty() ||
                fechaNacimiento == null) {

            mostrarAlerta("Por favor, ingrese todos los datos requeridos y asegúrese de que no estén vacíos.");
            return;
        }
        List<HistorialMedico> historialMedicoVacio = new ArrayList<>();

        Paciente nuevoPaciente = new Paciente(id,
                genero,
                nombres,
                apellidos,
                0,
                numeroTelefonico,
                correo,
                direccion,
                contrasena,
                fechaNacimiento,
                rh,
                historialMedicoVacio

        );
        nuevoPaciente.calcularYAsignarEdad();
        boolean exito = hospitalUQ.crearPaciente(nuevoPaciente);
        if (exito) {
            mostrarAlerta("¡Registro exitoso!" + "\nRecuerde que su usuario sera su número de documento (ID) :)");
        } else {
            mostrarAlerta("No se pudo registrar. Verifica los datos.");
        }

    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registro");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
