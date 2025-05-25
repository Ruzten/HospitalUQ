package co.edu.uniquindio.poo.proyectojavafx.controller;

import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class RegistrarseController {
    public void test() {
        System.out.println("Funciona");
    }

    public void registrarseUsuario(
            Genero genero,
            String nombres,
            String apellidos,
            String numeroTelefonico,
            String numeroDocumento,
            String correo,
            String direccion,
            TipoSangre rh,
            String contrasena,
            LocalDate fechaNacimiento) {

        if (genero == null ||
                nombres == null || nombres.trim().isEmpty() ||
                apellidos == null || apellidos.trim().isEmpty() ||
                numeroTelefonico == null || numeroTelefonico.trim().isEmpty() ||
                numeroDocumento == null || numeroDocumento.trim().isEmpty() ||
                correo == null || correo.trim().isEmpty() ||
                direccion == null || direccion.trim().isEmpty() ||
                rh == null ||
                contrasena == null || contrasena.isEmpty() ||
                fechaNacimiento == null) {

            mostrarAlerta("Por favor, ingrese todos los datos requeridos y asegúrese de que no estén vacíos.");
            return;
        }
        List<HistorialMedico> historialMedicoVacio = new ArrayList<>();

        Paciente nuevoPaciente = new Paciente(
                "",
                genero,
                nombres,
                apellidos,
                0, //
                numeroDocumento,
                numeroTelefonico,
                correo,
                direccion,
                contrasena,
                fechaNacimiento,
                rh,
                historialMedicoVacio
        );
        nuevoPaciente.calcularYAsignarEdad();
        boolean exito = HospitalUQ.crearPaciente(nuevoPaciente);
        if (exito) {
            mostrarAlerta("¡Registro exitoso!");
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
