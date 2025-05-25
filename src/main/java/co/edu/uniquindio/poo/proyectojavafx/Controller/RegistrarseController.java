package co.edu.uniquindio.poo.proyectojavafx.controller;

import co.edu.uniquindio.poo.proyectojavafx.model.HospitalUQ;
import co.edu.uniquindio.poo.proyectojavafx.model.Paciente;
import co.edu.uniquindio.poo.proyectojavafx.model.Genero;
import co.edu.uniquindio.poo.proyectojavafx.model.TipoSangre;
import javafx.scene.control.Alert;

import java.time.LocalDate;

public class RegistrarseController {

    public void registrarseUsuario (Genero genero, String nombres, String apellidos, String numeroTelefonico, String correo, String direccion, TipoSangre rh, String contrasena, LocalDate fechaNacimiento) {
        if (genero == null || nombres == null || apellidos == null || numeroTelefonico == null || correo == null || direccion == null || rh == null || contrasena == null || fechaNacimiento == null) {
            mostrarAlerta("Ingrese todos los datos requeridos.");
        }
        else {
            Paciente nuevoPaciente = new Paciente(
                "",
                genero,
                nombres,
                apellidos,
                0,
                numeroTelefonico,
                correo,
                direccion,
                contrasena,
                fechaNacimiento,
                rh
            );
            nuevoPaciente.calcularYAsignarEdad();
            boolean exito = HospitalUQ.crearPaciente(nuevoPaciente);
            if (exito){
                mostrarAlerta("¡Registro exitoso!");
            }
            else {
                mostrarAlerta("No se pudo registrar. Verifica los datos.");
            }

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
