package co.edu.uniquindio.poo.proyectojavafx.Model;
import java.util.ArrayList;
import java.util.List;

public class HospitalUQ {
    private String nombre;
    private ArrayList<Persona> listaMedicos;
    private ArrayList<Persona> listaPacientes;
    private ArrayList<Persona> listaAdministradores;
    private ArrayList<HistorialMedico> listaDeHistorialesMedicos;


    public HospitalUQ(String nombre) {
        this.nombre = nombre;
        this.listaMedicos = new ArrayList<>();
        this.listaPacientes = new ArrayList<>();
        this.listaAdministradores = new ArrayList<>();
        this.listaDeHistorialesMedicos = new ArrayList<>();
    }

    public ArrayList<Persona> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(ArrayList<Persona> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public ArrayList<HistorialMedico> getListaDeHistorialesMedicos() {
        return listaDeHistorialesMedicos;
    }

    public void setListaDeHistorialesMedicos(ArrayList<HistorialMedico> listaDeHistorialesMedicos) {
        this.listaDeHistorialesMedicos = listaDeHistorialesMedicos;
    }

    public ArrayList<Persona> getListaMedicos() {
        return listaMedicos;
    }

    public void setListaMedicos(ArrayList<Persona> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }

    public ArrayList<Persona> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ArrayList<Persona> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    // METODOS CREAR OBJETOS

    public boolean crearMedico(String id, Genero genero, String nombres, String apellidos, int edad, String telefono, String correo, String direccion, String contraseña, String matriculaLicencia, boolean certificado, String ubicacion, Estado estado, Especialidad especialidad) {
        boolean flag = false;
        for (Persona persona : listaMedicos) {
            if (persona.getId().equals(id)) {
                return flag;

            }
        }
        Medico nuevoMedico = new Medico(id, genero, nombres, apellidos, edad, telefono, correo, direccion, contraseña, matriculaLicencia, certificado, null, ubicacion, estado, especialidad);
        listaMedicos.add(nuevoMedico);
        flag = true;
        return flag;
    }

    public boolean crearPaciente(String id, Genero genero, String nombres, String apellidos, int edad, String telefono, String correo, String direccion, String contraseña, String fechaNacimiento, TipoSangre rh, List<HistorialMedico> listaHistorialMedico) {
        boolean flag = false;
        for (Persona persona : listaPacientes) {
            if (persona.getId().equals(id)) {
                return flag;
            }
        }
        Paciente nuevoPaciente = new Paciente(id, genero, nombres, apellidos, edad, telefono, correo, direccion, contraseña, fechaNacimiento, rh);

        if (listaDeHistorialesMedicos != null) {
            for (HistorialMedico historial : listaDeHistorialesMedicos) {
                nuevoPaciente.getHistorialMedico().add(historial);
            }
        }
        listaPacientes.add(nuevoPaciente);
        flag = true;
        return flag;
    }


}