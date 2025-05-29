package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.controller.MedicoController;
import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        txtNombrePaciente.setText(paciente.getNombres());
        txtNombreMedico.setText(medico.getNombres());
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

    public void registrarHistorialMedico(ActionEvent event) {
        try {
            // Validaciones básicas
            if (txtDiagnostico.getText().trim().isEmpty() || txtTratamiento.getText().trim().isEmpty()) {
                mostrarAlerta("Error, Los campos de diagnóstico y tratamiento son obligatorios.");
                return;
            }

            List<String> alergias = txtAlergias.getText().trim().isEmpty() ? null : Arrays.asList(txtAlergias.getText().split(","));
            String tipoSANGRE = "+O";

            // Convertir los archivos seleccionados a lista de rutas
            List<String> rutasArchivos = archivosSeleccionados.stream()
                    .map(File::getAbsolutePath)
                    .collect(Collectors.toList());

            // Crear el nuevo historial médico
            HistorialMedico nuevoHistorial = new HistorialMedico(
                    SesionTemporal.getPersonaSeleccionada().getId(),
                    (Paciente) paciente,
                    tipoSANGRE,
                    alergias,
                    LocalDate.now(),
                    LocalDateTime.now(),
                    txtDiagnostico.getText(),
                    txtTratamiento.getText(),
                    (Medico) medico,
                    rutasArchivos,
                    txtNotasAdicionales.getText()
            );

            // Agregar el historial médico usando el método del modelo
            boolean registroExitoso = MedicoController.agregarHistorialMedico(
                    SesionTemporal.getPersonaSeleccionada().getId(),
                    nuevoHistorial
            );

            if (registroExitoso) {
                mostrarAlerta("Éxito, Historial médico registrado correctamente.");
                Navegacion.volver();
            } else {
                mostrarAlerta("Error, No se pudo registrar el historial médico.");
            }

        } catch (Exception e) {
            mostrarAlerta("Error, Error al registrar el historial médico: " + e.getMessage());
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
