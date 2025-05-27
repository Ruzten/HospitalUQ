package co.edu.uniquindio.poo.proyectojavafx.model;

public class Consultorio {
    private String idConsultorio;
    private String nombreCosultorio;
    private boolean disponible;
    private Medico medicoAsignado;

    public Consultorio (String numeroConsultorio, String nombreCosultorio){
        this.idConsultorio = numeroConsultorio;
        this.nombreCosultorio = nombreCosultorio;
        this.disponible = true;
        this.medicoAsignado = null;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(Medico medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }

    public String getNombreCosultorio() {
        return nombreCosultorio;
    }
    public void asignarMedico (Medico medico){
        this.medicoAsignado = medico;
    }
    public void liberarMedico (){
        this.medicoAsignado = null;
    }

    public void setNombreCosultorio(String nombreCosultorio) {
        this.nombreCosultorio = nombreCosultorio;
    }

    public String getIdConsultorio() {
        return idConsultorio;
    }

    public void setNumeroConsultorio(String numeroConsultorio) {
        this.idConsultorio = numeroConsultorio;
    }
    @Override
    public String toString() {
        String infoMedico= (medicoAsignado != null) ? " - Medico: " + medicoAsignado.getNombres(): " - Sin medico asignado";
        return idConsultorio + " - " +  (disponible ?  "Disponible" : "Ocupado" ) +nombreCosultorio + infoMedico;
    }
}
