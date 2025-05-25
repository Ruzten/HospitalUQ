package co.edu.uniquindio.poo.proyectojavafx.model;

public enum Genero {
    MASCULINO("Hombre"),
    FEMENINO("Mujer");

    private final String texto;

    Genero(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}

