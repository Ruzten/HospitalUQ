package co.edu.uniquindio.poo.proyectojavafx.Model;

public enum TipoSangre {
    A_POSITIVO("A+"), A_NEGATIVO("A-"),
    B_POSITIVO("B+"), B_NEGATIVO("B-"),
    O_POSITIVO("O+"), O_NEGATIVO("O-"),
    AB_POSITIVO("AB+"), AB_NEGATIVO("AB-");

    private final String simbolo;

    TipoSangre(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
