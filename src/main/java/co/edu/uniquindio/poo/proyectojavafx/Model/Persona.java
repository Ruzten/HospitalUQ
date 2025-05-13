package co.edu.uniquindio.poo.proyectojavafx.Model;

import java.util.Objects;

public abstract class Persona {
    private String id;
    private Genero genero;
    private String nombres;
    private String apellidos;
    private int edad;
    private String telefono;
    private String correo;
    private String direccion;
    private String contraseña;

    public Persona(String id, Genero genero, String nombres, String apellidos, int edad, String telefono, String correo, String direccion, String contraseña) {
        this.id = id;
        this.genero = genero;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.contraseña = contraseña;
    }

    protected Persona() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
