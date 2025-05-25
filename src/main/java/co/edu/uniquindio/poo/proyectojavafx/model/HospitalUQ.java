package co.edu.uniquindio.poo.proyectojavafx.model;

import java.util.List;
import java.util.LinkedList;

public class HospitalUQ {
    private String nombre;
    private static LinkedList<Persona> listaPersonas;
    private static LinkedList<Medico> listaMedicos;
    private static LinkedList<Paciente> listaPacientes;
    private static LinkedList<Administrador> listaAdministradores;
    private LinkedList<HistorialMedico> listaDeHistorialesMedicos;


    public HospitalUQ(String nombre) {
        this.nombre = nombre;
        this.listaMedicos = new LinkedList<>();
        this.listaPacientes = new LinkedList<>();
        this.listaAdministradores = new LinkedList<>();
        this.listaDeHistorialesMedicos = new LinkedList<>();
    }

    // DATOS QUEMADOS PRUEBA LOGIN :D
    public void iniciarDatosQuemados () {
        Paciente pacientePrueba = new Paciente(
                "pacienteprueba",                         // id
                Genero.MASCULINO,              // género
                "Juan",                        // nombres
                "Pérez",                       // apellidos
                30,                            // edad
                "3111234567",                  // teléfono
                "juan@mail.com",              // correo
                "Calle 123",                   // dirección
                "1234",                        // contraseña
                "1993-05-10",                  // fecha de nacimiento
                TipoSangre.O_POSITIVO          // RH
        );
        listaPacientes.add(pacientePrueba);

        List<Horario> horariosPrueba = new LinkedList<>();
        horariosPrueba.add(new Horario("Lunes", "08:00", "12:00"));

        Medico medicoPrueba = new Medico(
                "docprueba",                          // id
                Genero.FEMENINO,                // género
                "Laura",                        // nombres
                "Gómez",                        // apellidos
                40,                             // edad
                "3107894561",                   // teléfono
                "laura@hospitaluq.com",         // correo
                "Carrera 45 #10-12",            // dirección
                "5678",                          // contraseña
                "LIC1234",                       // número de licencia
                true,                            // certificado
                horariosPrueba,                 // horarios
                "Consultorio 5B",               // ubicación
                Estado.ACTIVO,                  // estado
                Especialidad.CARDIOLOGO        // especialidad
        );
        listaMedicos.add(medicoPrueba);
        Administrador adminPrueba = new Administrador(
                "admin",
                Genero.MASCULINO,
                "Alex",
                "Ramírez",
                35,
                "3000000000",
                "admin@hospitaluq.com",
                "Oficina central",
                "admin"
        );
        listaAdministradores.add(adminPrueba);
    }

    // METODO DE BUSCAR USUARIO PARA LOGIN
    public static Object buscarUsuario(String usuario, String contrasena) {
        for (Paciente paciente : HospitalUQ.listaPacientes) {
            if (paciente.getId().equals(usuario) && paciente.getContrasena().equals(contrasena)) {
                return paciente;
            }
        }
        for (Medico medico : listaMedicos) {
            if (medico.getId().equals(usuario) && medico.getContrasena().equals(contrasena)) {
                return medico;
            }
        }
        for (Administrador admin : listaAdministradores) {
            if (admin.getId().equals(usuario) && admin.getContrasena().equals(contrasena)) {
                return admin;
            }
        }
        return null;
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
        if(actuPaciente == null || actuPaciente.getId() == null){
            return null;
        }

        for (Paciente paciente : listaPacientes) {
            if (paciente.getId().equals(actuPaciente.getId())) {
                try {
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
                }catch (Exception e) {
                    throw e;
                }
            }
            return null;
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

        String Id = String.format("P%010d", listaPacientes.size() + 1);
        newpaciente.setId(Id);

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

    public List<HistorialMedico> obtenerHistorialMedicoPaciente(String idPaciente){
        Paciente paciente = buscarPaciente(idPaciente);
        if(paciente != null){
            return paciente.getHistorialMedico();
        }
        return null;
    }

    public List<Paciente> obtenerPacientes(){
        List<Paciente> newlistPacientes = new LinkedList<>();
        for(Paciente paciente : this.listaPacientes){
            newlistPacientes.add(paciente);
        }
        return listaPacientes;
    }

    public boolean agregarHistorialMedico(String idPaciente, HistorialMedico historialMedico){
        Paciente paciente = buscarPaciente(idPaciente);
        if(paciente != null){
            HistorialMedico nuevoHistorialMedico = new HistorialMedico(historialMedico.getFecha(), historialMedico.getDiagnostico(), historialMedico.getTratamiento(), historialMedico.getObservaciones(), historialMedico.getMedicoTratante());
            paciente.getHistorialMedico().add(nuevoHistorialMedico);
            return true;
        }
        return false;
    }
}