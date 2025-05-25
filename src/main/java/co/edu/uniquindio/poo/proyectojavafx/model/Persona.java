package co.edu.uniquindio.poo.proyectojavafx.model;

import java.util.Objects;

public abstract class Persona {
    protected String id;
    private Genero genero;
    private String nombres;
    private String apellidos;
    private int edad;
    private String NumeroDocumento;
    private String telefono;
    private String correo;
    private String direccion;
    private String contrasena;

    public Persona(String id, Genero genero, String nombres, String apellidos, int edad, String NumeroDocumento, String telefono, String correo, String direccion, String contrasena) {
        this.id = id;
        this.genero = genero;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.NumeroDocumento = NumeroDocumento;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.contrasena = contrasena;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }

    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        NumeroDocumento = numeroDocumento;
    }
}
