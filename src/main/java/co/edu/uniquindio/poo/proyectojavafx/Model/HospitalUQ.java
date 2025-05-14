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

    public Medico ActualizarMedico(Medico newmedico) {
        boolean flag = false;
        for (Medico medico : listaMedicos) {
            if (medico.getId().equals(newmedico.getId())) {
                medico.setGenero(newmedico.getGenero());
                medico.setNombres(newmedico.getNombres());
                medico.setApellidos(newmedico.getApellidos());
                medico.setEdad(newmedico.getEdad());
                medico.setTelefono(newmedico.getTelefono());
                medico.setCorreo(newmedico.getCorreo());
                medico.setDireccion(newmedico.getDireccion());
                medico.setContrasena(newmedico.getContrasena());
                medico.setNLicencia(newmedico.getNLicencia());
                medico.setUbicacion(newmedico.getUbicacion());
                medico.setEstado(newmedico.getEstado());
                medico.setEspecialidad(newmedico.getEspecialidad());
                medico.setHorarios(newmedico.getHorarios());
                medico.setCertificado(newmedico.getCertificado());
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

    public Paciente actualizarPaciente(Paciente actuPaciente) {
        boolean flag = false;
        for (Paciente paciente : listaPacientes) {
            if (paciente.getId().equals(actuPaciente.getId())) {
                paciente.setGenero(actuPaciente.getGenero());
                paciente.setNombres(actuPaciente.getNombres());
                paciente.setApellidos(actuPaciente.getApellidos());
                paciente.setEdad(actuPaciente.getEdad());
                paciente.setTelefono(actuPaciente.getTelefono());
                paciente.setCorreo(actuPaciente.getCorreo());
                paciente.setDireccion(actuPaciente.getDireccion());
                paciente.setContrasena(actuPaciente.getContrasena());
                paciente.setFechaNacimiento(actuPaciente.getFechaNacimiento());
                paciente.setRh(actuPaciente.getRh());
                paciente.setHistorialMedico(actuPaciente.getHistorialMedico());

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


    public boolean crearPaciente(Paciente newpaciente) {
        if (newpaciente == null) {
            return false;
        }

        if (newpaciente.getId() == null || newpaciente.getId().trim().isEmpty()) {
            return false;
        }

        // Verificar que no hay duplicados
        for (Paciente paciente : listaPacientes) {
            if (paciente.getId().equals(newpaciente.getId())) {
                return false;
            }
        }

        listaPacientes.add(newpaciente);
        return true;
    }

    public boolean ActualizarHistorialMedico(String idPaciente, HistorialMedico historialMedico){
        Paciente paciente = buscarPaciente(idPaciente);
        if(paciente != null){
            List<HistorialMedico> historialMedicos = paciente.getHistorialMedico();
            for(int i = 0; i < historialMedicos.size(); i++){
                if(historialMedicos.get(i).getFecha().equals(historialMedico.getFecha())){
                    historialMedicos.get(i).setDiagnostico(historialMedico.getDiagnostico());
                    historialMedicos.get(i).setTratamiento(historialMedico.getTratamiento());
                    historialMedicos.get(i).setObservaciones(historialMedico.getObservaciones());
                    return true;
                }
            }
        }
        return  false;
    }
}