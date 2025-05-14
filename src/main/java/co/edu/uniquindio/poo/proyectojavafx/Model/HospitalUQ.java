package co.edu.uniquindio.poo.proyectojavafx.Model;

import java.util.List;
import java.util.LinkedList;

public class HospitalUQ {
    private String nombre;
    private LinkedList<Persona> listaPersonas;
    private LinkedList<Medico> listaMedicos;
    private LinkedList<Paciente> listaPacientes;
    private LinkedList<Administrador> listaAdministradores;
    private LinkedList<HistorialMedico> listaDeHistorialesMedicos;


    public HospitalUQ(String nombre) {
        this.nombre = nombre;
        this.listaMedicos = new LinkedList<>();
        this.listaPacientes = new LinkedList<>();
        this.listaAdministradores = new LinkedList<>();
        this.listaDeHistorialesMedicos = new LinkedList<>();
    }


    public LinkedList<HistorialMedico> getListaDeHistorialesMedicos() {
        return listaDeHistorialesMedicos;
    }

    public void setListaDeHistorialesMedicos(LinkedList<HistorialMedico> listaDeHistorialesMedicos) {
        this.listaDeHistorialesMedicos = listaDeHistorialesMedicos;
    }

    public LinkedList<Persona> getListaMedicos() {
        return listaPersonas;
    }

    public LinkedList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(LinkedList<Paciente> listaPacientes) {

        this.listaPacientes = listaPacientes;
    }

    public LinkedList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(LinkedList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public void setListaMedicos(LinkedList<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }

    public LinkedList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(LinkedList<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean crearMedico(Medico newMedico) {
        if (newMedico == null) {
            return false;
        }

        if (newMedico.getId() == null || newMedico.getId().trim().isEmpty()) {
            return false;
        }

        // Verificar que no hay duplicados
        for (Medico medico : listaMedicos) {
            if (medico.getId().equals(newMedico.getId())) {
                return false;
            }
        }

        listaMedicos.add(newMedico);
        return true;
    }



    public boolean eliminarMedico(String id) {
        boolean flag = false;
        for (Medico medico : listaMedicos) {
            if (medico.getId().equals(id)) {
                listaMedicos.remove(medico);
                flag = true;
                return true;
            }
        }
        return flag;
    }

    public Medico ActualizarMedico(String id, Genero genero, String nombres, String apellidos, int edad, String telefono, String correo, String direccion, String contraseña, String matriculaLicencia, boolean certificado, String ubicacion, Estado estado, Especialidad especialidad) {
        boolean flag = false;
        for (Medico medico : listaMedicos) {
            if (medico.getId().equals(id)) {
                medico.setGenero(genero);
                medico.setNombres(nombres);
                medico.setApellidos(apellidos);
                medico.setEdad(edad);
                medico.setTelefono(telefono);
                medico.setCorreo(correo);
                medico.setDireccion(direccion);
                medico.setContraseña(contraseña);
                medico.setMatriculaLicencia(matriculaLicencia);
                medico.setCertificado(certificado);
                medico.setUbicacion(ubicacion);
                medico.setEstado(estado);
                medico.setEspecialidad(especialidad);

                return medico;
            }
        }
        return null;
    }

    public Medico buscarMedico(String id) {
        for (Medico medico : listaMedicos) {
            if (medico.getId().equals(id)) {
                return medico;
            }
        }
        return null;
    }

    public Paciente actualizarPaciente(String id, Genero genero, String nombres, String apellidos, int edad, String telefono, String correo, String direccion, String contraseña, String fechaNacimiento, TipoSangre rh) {
        boolean flag = false;
        for (Paciente paciente : listaPacientes) {
            if (paciente.getId().equals(id)) {
                paciente.setGenero(genero);
                paciente.setNombres(nombres);
                paciente.setApellidos(apellidos);
                paciente.setEdad(edad);
                paciente.setTelefono(telefono);
                paciente.setCorreo(correo);
                paciente.setDireccion(direccion);
                paciente.setContraseña(contraseña);
                paciente.setFechaNacimiento(fechaNacimiento);
                paciente.setRh(rh);

                return paciente;
            }
        }

        return null;
    }

    public boolean eliminarPaciente(String id) {
        boolean flag = false;
        for (Paciente paciente : listaPacientes) {
            if (paciente.getId().equals(id)) {
                listaPacientes.remove(paciente);
                flag = true;
                return true;
            }
        }
        return flag;
    }

    public Paciente buscarPaciente(String id) {
        for (Paciente paciente : listaPacientes) {
            if (paciente.getId().equals(id)) {
                return paciente;
            }
        }
        return null;
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