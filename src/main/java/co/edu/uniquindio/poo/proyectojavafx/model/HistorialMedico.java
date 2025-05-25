package co.edu.uniquindio.poo.proyectojavafx.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class HistorialMedico {
    private String id;
    private Paciente paciente;
    private List<EntradaHistorial> entradas;
    private String grupoSanguineo;
    private List<String> alergias;
    private List<String> antecedentes;
    private LocalDate fechaCreacion;

    public HistorialMedico(String id, Paciente paciente, String grupoSanguineo) {
        this.id = id;
        this.paciente = paciente;
        this.grupoSanguineo = grupoSanguineo;
        this.entradas = new ArrayList<>();
        this.alergias = new ArrayList<>();
        this.antecedentes = new ArrayList<>();
        this.fechaCreacion = LocalDate.now();
    }

    // Getters y Setters básicos
    public String getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<EntradaHistorial> getEntradas() {
        return entradas;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public List<String> getAntecedentes() {
        return antecedentes;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    // Métodos para gestionar entradas
    public void agregarEntrada(EntradaHistorial entrada) {
        entradas.add(entrada);
    }

    public void eliminarEntrada(EntradaHistorial entrada) {
        entradas.remove(entrada);
    }

}
