package co.edu.uniquindio.poo.proyectojavafx.viewController;

import co.edu.uniquindio.poo.proyectojavafx.model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PacienteAgendarCitaMedicaViewController {
    private Paciente pacienteActual = (Paciente) Sesion.getUsuarioActual();
    private HospitalUQ hospitalUQ = HospitalUQ.getInstancia();
    private Medico medicoSeleccionado;
    @FXML
    private ComboBox<Especialidad> comboEspecialidad;
    @FXML
    private ComboBox<Medico> comboMedico;
    @FXML
    private DatePicker dateFecha;
    @FXML
    private ComboBox<LocalTime> comboHora;
    @FXML
    private TextArea txtMotivo;
    @FXML
    private Text mensajeBueno;
    @FXML
    private Text mensajeMalo;

    @FXML
    public void initialize() {
        comboEspecialidad.setItems(FXCollections.observableArrayList(Especialidad.values()));
        comboEspecialidad.setPromptText("Seleccione una especialidad");
        comboMedico.setDisable(true);
        dateFecha.setDisable(true);
        comboHora.setDisable(true);
        txtMotivo.setDisable(true);
        comboMedico.setPromptText("Seleccione un médico");
        comboHora.setPromptText("Seleccione una hora");

        comboEspecialidad.valueProperty().addListener((obs, oldVal, seleccionEspecialidad) -> {
            if (seleccionEspecialidad != null) {
                List<Medico> medicosPorEspecialidad = hospitalUQ.buscarMedicoPorEspecialidad(seleccionEspecialidad);

                comboMedico.setItems(FXCollections.observableArrayList(medicosPorEspecialidad));

                comboMedico.setDisable(false);
                dateFecha.setDisable(true);
                comboHora.setDisable(true);
                txtMotivo.setDisable(true);
                comboMedico.getSelectionModel().clearSelection();
                dateFecha.setValue(null);
                comboHora.getItems().clear();
            } else {
                comboMedico.setDisable(true);
                dateFecha.setDisable(true);
                comboHora.setDisable(true);
                txtMotivo.setDisable(true);
                comboMedico.getItems().clear();
                dateFecha.setValue(null);
                comboHora.getItems().clear();
            }
        });

        comboMedico.valueProperty().addListener((obs, oldVal, seleccionMedico) -> {
            if (seleccionMedico != null) {
                this.medicoSeleccionado = seleccionMedico;
                System.out.println("Médico seleccionado: " + medicoSeleccionado.getNombres() + " " + medicoSeleccionado.getApellidos());
                dateFecha.setDisable(false);
                comboHora.setDisable(true);
                txtMotivo.setDisable(true);
                dateFecha.setValue(null);
                comboHora.getItems().clear();

            } else {
                this.medicoSeleccionado = null;
                dateFecha.setDisable(true);
                comboHora.setDisable(true);
                txtMotivo.setDisable(true);
                dateFecha.setValue(null);
                comboHora.getItems().clear();
            }
        });


        dateFecha.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null && comboMedico.getSelectionModel().getSelectedItem() != null) {
                cargarHorasDisponibles(newVal, medicoSeleccionado);
                comboHora.setDisable(false);
                txtMotivo.setDisable(false);
            } else {
                comboHora.setDisable(true);
                txtMotivo.setDisable(true);
                comboHora.getItems().clear();
            }
        });
    }

    @FXML
    public void volverAtras(ActionEvent event) throws IOException {
        Navegacion.volver();
    }

    private void cargarHorasDisponibles(LocalDate fecha, Medico medico) {
        // Asegúrate de que el médico y la fecha no sean nulos
        if (medico == null || fecha == null) {
            comboHora.getItems().clear();
            return;
        }


        DayOfWeek diaSemanaSeleccionado = fecha.getDayOfWeek();

        List<Horario> horariosMedico = medico.getHorarios();

        List<LocalTime> horasDisponibles = new ArrayList<>();

        if (horariosMedico != null) {
            for (Horario horario : horariosMedico) {
                if (horario.getDiaSemana() == diaSemanaSeleccionado) {
                    horasDisponibles.add(horario.getHoraInicio());
                }
            }
        }

        horasDisponibles.sort(LocalTime::compareTo);

        comboHora.setItems(FXCollections.observableArrayList(horasDisponibles));

        if (horasDisponibles.isEmpty()) {
            comboHora.setPromptText("No hay horas disponibles para esta fecha");
        } else {
            comboHora.setPromptText("Seleccione una hora");
        }
    }

    @FXML
    public void confirmar(ActionEvent event) {
        Especialidad especialidadSeleccionada = comboEspecialidad.getSelectionModel().getSelectedItem();
        LocalDate fechaSeleccionada = dateFecha.getValue();
        LocalTime horaSeleccionada = comboHora.getSelectionModel().getSelectedItem();
        String motivoCita = txtMotivo.getText();
        LocalDateTime fechaHoraCita = LocalDateTime.of(fechaSeleccionada, horaSeleccionada);
        Horario horarioParaCita = null;
        if (medicoSeleccionado != null && medicoSeleccionado.getHorarios() != null) {
            DayOfWeek diaSeleccionado = fechaSeleccionada.getDayOfWeek();
            for (Horario h : medicoSeleccionado.getHorarios()) {
                if (h.getDiaSemana() == diaSeleccionado && h.getHoraInicio().equals(horaSeleccionada)) {
                    horarioParaCita = h;
                    break;
                }
            }
        }
        if (especialidadSeleccionada == null || medicoSeleccionado == null || fechaSeleccionada == null ||
                horaSeleccionada == null || horarioParaCita == null || motivoCita.trim().isEmpty()) {
            mensajeMalo.setText("Faltan datos para agendar la cita.");
            mensajeMalo.setVisible(true);

            return;
        }
        if (fechaHoraCita.isBefore(LocalDateTime.now())) {
            mensajeMalo.setText("Error: No se puede agendar citas en el pasado.");
            mensajeMalo.setVisible(true);
            return;
        }
        Cita nuevaCita = new Cita(
                pacienteActual,
                medicoSeleccionado,
                fechaHoraCita,
                horarioParaCita,
                motivoCita);

        enviarCorreoConfirmacionMedico();
        enviarCorreoConfirmacionPaciente();
        medicoSeleccionado.agregarCita(nuevaCita);
        hospitalUQ.agregarCitaGlobal(nuevaCita);
        mensajeMalo.setVisible(false);
        mensajeBueno.setVisible(true);

    }

    public void enviarCorreoConfirmacionPaciente () {
        String motivoCita = txtMotivo.getText();
        LocalDate fechaHoraCita = dateFecha.getValue();
        EmailService emailService = new EmailService();

        String correo = pacienteActual.getCorreo(); // ← correo del paciente asociado
        String asunto = "Confirmación de cita médica";
        String cuerpo = "Hola " + pacienteActual.getNombreCompleto() + ",\n\n" +
                "Tu cita fue agendada exitosamente con el Dr(a). " +
                medicoSeleccionado.getNombreCompleto() + " para el día " +
                fechaHoraCita + " a las " + comboHora.getSelectionModel().getSelectedItem() + ".\n\n" +
                "Motivo: " + motivoCita + "\n\n" +
                "Gracias por confiar en HospitalUQ.";

        emailService.enviarCorreo(correo, asunto, cuerpo);
    }

    public  void enviarCorreoConfirmacionMedico () {
        String motivoCita = txtMotivo.getText();
        LocalDate fechaHoraCita = dateFecha.getValue();
        EmailService emailService = new EmailService();

        String correo = medicoSeleccionado.getCorreo(); // ← correo del paciente asociado
        String asunto = "Confirmación de cita médica al paciente " + pacienteActual.getNombreCompleto();
        String cuerpo = "Saludos " + medicoSeleccionado.toString() + ",\n\n" +
                "La cita del paciente " + pacienteActual.getNombreCompleto() + " fue agendada exitosamente con usted para el día " +
                fechaHoraCita + " a las " + comboHora.getSelectionModel().getSelectedItem() + ".\n\n" +
                "Motivo: " + motivoCita + "\n\n" +
                "Gracias por servir al HospitalUQ.";

        emailService.enviarCorreo(correo, asunto, cuerpo);
    }
}