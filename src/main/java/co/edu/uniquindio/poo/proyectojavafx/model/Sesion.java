package co.edu.uniquindio.poo.proyectojavafx.model;

public class Sesion {
    private static Persona usuarioActual;

    public static Persona getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Persona usuario) {
        usuarioActual = usuario;
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }
}
