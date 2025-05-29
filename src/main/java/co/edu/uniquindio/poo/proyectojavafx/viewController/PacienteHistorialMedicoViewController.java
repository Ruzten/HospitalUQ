package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class PacienteHistorialMedicoViewController {
    private Paciente paciente = (Paciente) Sesion.getUsuarioActual();
    private HospitalUQ hospitalUQ = HospitalUQ.getInstancia();
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
        cargarHistorialPaciente();
    }

    public void cargarHistorialPaciente() {
        ArrayList<Cita> citas = hospitalUQ.HistorialMedicoPorPaciente(paciente);
        tableHistorialMedico.setItems(FXCollections.observableArrayList(citas));
    }
}
