package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.annotation.processing.Generated;
import java.util.ArrayList;

public class PacienteCitasMedicasViewController {
    private HospitalUQ hospitalUQ = HospitalUQ.getInstancia();
    private Paciente paciente = (Paciente) Sesion.getUsuarioActual();
    @FXML
    private TableView<Cita> tableCitas;
    @FXML
    private TableColumn<Cita, String> colFecha;
    @FXML
    private TableColumn<Cita, String> colHora;
    @FXML
    private TableColumn<Cita, String> colMedico;
    @FXML
    private TableColumn<Cita, String> colEspecialidad;

    @FXML
    public void volverAtras(ActionEvent event) {
        Navegacion.volver();
    }

    @FXML
    public void initialize() {
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaSimple"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        colMedico.setCellValueFactory(new PropertyValueFactory<>("nombreMedico"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));

        cargarCitasPaciente();
    }

    @FXML
    public void cancelarCitaSeleccionada(ActionEvent event) {
        Cita citaSeleccionada = (Cita) tableCitas.getSelectionModel().getSelectedItem();

        if (citaSeleccionada != null) {
            citaSeleccionada.cancelarCita();
            cargarCitasPaciente();
        }
    }

    public void cargarCitasPaciente() {
        ArrayList<Cita> citas = hospitalUQ.citasPorPaciente(paciente);
        tableCitas.setItems(FXCollections.observableArrayList(citas));
    }
}
