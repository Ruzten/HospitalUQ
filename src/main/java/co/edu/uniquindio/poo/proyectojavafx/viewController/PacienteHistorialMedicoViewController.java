package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class PacienteHistorialMedicoViewController {
    private Paciente paciente = (Paciente) Sesion.getUsuarioActual();
    @FXML
    private TableView tableHistorialMedico;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colFecha;
    @FXML
    private TableColumn colDoctor;
    @FXML
    private TableColumn colDiagnostico;
    @FXML
    private TableColumn colTratamiento;
    @FXML
    private TableColumn colArchivoAdjunto;
    @FXML
    private TableColumn colNotas;

    @FXML
    public void volverAtras (ActionEvent event) {
        Navegacion.volver();
    }

    @FXML
    public void initialize () {
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("hora"));
        colDoctor.setCellValueFactory(new PropertyValueFactory<>("nombreMedico"));
        colDiagnostico.setCellValueFactory(new PropertyValueFactory<>("Diagnostico"));
        colTratamiento.setCellValueFactory(new PropertyValueFactory<>("Tratamiento"));
        colArchivoAdjunto.setCellValueFactory(new PropertyValueFactory<>("ArchivoAdjunto"));
        colNotas.setCellValueFactory(new PropertyValueFactory<>("Notas"));
        cargarHistorialMedico();
    }

    public void cargarHistorialMedico() {
        List<HistorialMedico> historial = paciente.getHistorialMedico();
        if (historial == null) historial = new ArrayList<>();
        ObservableList<HistorialMedico> lista = FXCollections.observableArrayList(historial);

    }

}
