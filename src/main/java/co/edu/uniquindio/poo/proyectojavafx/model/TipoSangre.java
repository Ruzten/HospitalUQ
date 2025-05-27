package co.edu.uniquindio.poo.proyectojavafx.model;

public enum TipoSangre {
    A_POSITIVO("A+"), A_NEGATIVO("A-"),
    B_POSITIVO("B+"), B_NEGATIVO("B-"),
    O_POSITIVO("O+"), O_NEGATIVO("O-"),
    AB_POSITIVO("AB+"), AB_NEGATIVO("AB-");

    private final String texto;

    TipoSangre(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}
