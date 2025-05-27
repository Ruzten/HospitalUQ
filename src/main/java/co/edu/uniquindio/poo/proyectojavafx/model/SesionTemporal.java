package co.edu.uniquindio.poo.proyectojavafx.model;

public class SesionTemporal {
    public static Persona personaSeleccionada;

    public static Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public static void setPersonaSeleccionada(Persona usuario) {
        personaSeleccionada = usuario;
    }

    public static void olvidarPersonaSeleccionada() {
        personaSeleccionada = null;
    }
}
