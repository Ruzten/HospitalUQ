package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class DoctorRegistrarHorarioDisponibleViewController {
    Medico medico = (Medico) Sesion.getUsuarioActual();
    @FXML
    private ChoiceBox<DayOfWeek> choiceDiaSemana;
    @FXML
    private TextField txtHoraInicio;
    @FXML
    private TextField txtHoraFin;
    @FXML
    public void initialize () {
        choiceDiaSemana.getItems().addAll(DayOfWeek.values());
    }
    @FXML
    public void volverAtras(ActionEvent event) throws IOException {
        Navegacion.volver();
    }
    @FXML
    public void confirmar (ActionEvent event) throws IOException {
        try {
            DayOfWeek dia = choiceDiaSemana.getValue();
            LocalTime horaInicio = LocalTime.parse(txtHoraInicio.getText());
            LocalTime horaFin = LocalTime.parse(txtHoraFin.getText());

            if (horaInicio.isAfter(horaFin)) {
                mostrarAlerta("La hora de inicio debe ser antes que la hora de fin.");
                return;
            }

            Horario nuevoHorario = new Horario(dia, horaInicio, horaFin);

            // Verificar que no se cruce con los existentes
            for (Horario h : medico.getHorarios()) {
                if (nuevoHorario.coincideCon(h)) {
                    mostrarAlerta("El horario se cruza con uno ya existente.");
                    return;
                }
            }

            medico.getHorarios().add(nuevoHorario);
            mostrarAlerta("Horario añadido exitosamente!");
            Navegacion.volver();

        } catch (Exception e) {
            mostrarAlerta("Formato inválido. Usa HH:mm para las horas.");
        }
    }
    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
