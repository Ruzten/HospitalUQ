package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DoctorRegistrarHistorialMedicoViewController {
    Persona medico = Sesion.getUsuarioActual();
    Persona paciente = SesionTemporal.getPersonaSeleccionada();

    @FXML
    private Text txtIdPaciente;
    @FXML
    private Text txtNombrePaciente;
    @FXML
    private Text txtNombreMedico;
    @FXML
    private Text txtFechaActual;
    @FXML
    private ListView<String> listaArchivos;
    @FXML
    private TextArea txtDiagnostico;
    @FXML
    private TextArea txtTratamiento;
    @FXML
    private TextArea txtNotasAdicionales;
    @FXML
    private TextArea txtAlergias;

    private final ObservableList<File> archivosSeleccionados = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        txtIdPaciente.setText(paciente.getId());
        txtNombrePaciente.setText(paciente.getNombreCompleto());
        txtNombreMedico.setText(medico.getNombreCompleto());
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        txtFechaActual.setText(hoy.format(formatter));
    }

    @FXML
    public void volverAtras(ActionEvent event) throws IOException {
        Navegacion.volver();
    }

    @FXML
    public void agregarArchivo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivos");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg")
        );

        Window stage = listaArchivos.getScene().getWindow();
        List<File> archivos = fileChooser.showOpenMultipleDialog(stage);

        if (archivos != null) {
            archivosSeleccionados.addAll(archivos);
            for (File archivo : archivos) {
                listaArchivos.getItems().add(archivo.getName());
            }
        }
    }
}
