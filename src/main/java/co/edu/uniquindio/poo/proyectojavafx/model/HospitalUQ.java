package co.edu.uniquindio.poo.proyectojavafx.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class HospitalUQ {
    private String nombre;
    private static LinkedList<Persona> listaPersonas;
    private static LinkedList<Medico> listaMedicos;
    private static LinkedList<Paciente> listaPacientes;
    private static LinkedList<Administrador> listaAdministradores;
    private LinkedList<HistorialMedico> listaDeHistorialesMedicos;
    private ArrayList<Cita> citasGlobales;
    private static HospitalUQ instancia;
    private Persona paciente = Sesion.getUsuarioActual();


    public HospitalUQ(String nombre) {
        this.nombre = nombre;
        this.listaMedicos = new LinkedList<>();
        this.listaPacientes = new LinkedList<>();
        this.listaAdministradores = new LinkedList<>();
        this.listaDeHistorialesMedicos = new LinkedList<>();
        this.citasGlobales = new ArrayList<>();
    }

    public static HospitalUQ getInstancia() {
        if (instancia == null) {
            instancia = new HospitalUQ("HospitalUQ");
        }
        return instancia;
    }

    // DATOS QUEMADOS PRUEBA LOGIN :D
    public void iniciarDatosQuemados() {
        List<HistorialMedico> historialPaciente = new ArrayList<>();
        Paciente pacientePrueba = new Paciente(
                "pacienteprueba",                                   // id
                Genero.FEMENINO,                            // genero
                "Laura",                                    // nombres
                "Martínez",                                 // apellidos
                0,                                          // edad (se calculará después con calcularYAsignarEdad)
                "3201234567",                               // telefono
                "laura.martinez@mail.com",                  // correo
                "Carrera 10 #5-20",                         // direccion
                "1234",                             // contrasena
                LocalDate.parse("1990-03-05"),   // fechaNacimiento (LocalDate)
                TipoSangre.A_NEGATIVO,                      // rh (asumo un enum TipoSangre)
                historialPaciente                           // historialMedico (la lista que creaste arriba)
        );
        listaPacientes.add(pacientePrueba);

        List<Horario> horariosPrueba = new LinkedList<>();
        horariosPrueba.add(new Horario(DayOfWeek.MONDAY, LocalTime.parse("08:00"), LocalTime.parse("12:00")));

        List<Horario> horariosMedico = new ArrayList<>();
        List<Cita> citasMedico = new ArrayList<>();

        List<HistorialMedico> historialesMedico = new ArrayList<>();
        Medico medicoPrueba = new Medico(
                "medicoprueba",                     // id
                Genero.MASCULINO,                    // genero
                "Carlos",                  // nombres
                "Ramírez",                 // apellidos
                45,                        // edad
                "3001234567",              // teléfono
                "carlos@hospital.com",     // correo
                "Calle 123 #45-67",        // dirección
                "1234",             // contraseña
                "LIC-98765",               // NLicencia
                true,                      // certificado
                horariosMedico,                  // horarios
                "Bogotá",                  // ubicación
                Estado.ACTIVO,                    // estado
                Especialidad.CARDIOLOGO,              // especialidad
                citasMedico,           // citas asignadas
                historialesMedico      // historiales pacientes
        );
        listaMedicos.add(medicoPrueba);
        Medico medicoPrueba1 = new Medico(
                "medicoprueba1",                     // id
                Genero.FEMENINO,                    // genero
                "Carla",                  // nombres
                "Perez",                 // apellidos
                45,                        // edad
                "3001234567",              // teléfono
                "carlos@hospital.com",     // correo
                "Calle 123 #45-67",        // dirección
                "1234",             // contraseña
                "LIC-98765",               // NLicencia
                true,                      // certificado
                horariosMedico,                  // horarios
                "Bogotá",                  // ubicación
                Estado.ACTIVO,                    // estado
                Especialidad.MEDICO_GENERAL,              // especialidad
                citasMedico,           // citas asignadas
                historialesMedico      // historiales pacientes
        );
        listaMedicos.add(medicoPrueba1);
        Medico medicoPrueba2 = new Medico(
                "medicoprueba2",                     // id
                Genero.MASCULINO,                    // genero
                "pepe",                  // nombres
                "Carota",                 // apellidos
                45,                        // edad
                "3001234567",              // teléfono
                "carlos@hospital.com",     // correo
                "Calle 123 #45-67",        // dirección
                "1234",             // contraseña
                "LIC-98765",               // NLicencia
                true,                      // certificado
                horariosMedico,                  // horarios
                "Bogotá",                  // ubicación
                Estado.ACTIVO,                    // estado
                Especialidad.MEDICO_GENERAL,              // especialidad
                citasMedico,           // citas asignadas
                historialesMedico      // historiales pacientes
        );
        listaMedicos.add(medicoPrueba2);
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

    // Metodo de agregar citaGlobal
    public void agregarCitaGlobal (Cita cita) {
        citasGlobales.add(cita);
        System.out.println("cita agg al global");
    }
    // Metodo de buscar la cita segun el paciente
    public ArrayList<Cita> citasPorPaciente (Paciente paciente) {
        ArrayList citas = new ArrayList<>();
        for (Cita cita : citasGlobales) {
            boolean x = cita.getEstado().equals(EstadoCita.PROGRAMADA);
            if (cita.getPaciente() == paciente && x )
                citas.add(cita);
        }
        return citas;
    }

    // METODO DE BUSCAR USUARIO PARA LOGIN
    public static Object buscarUsuario(String id, String contrasena) {
        for (Paciente paciente : HospitalUQ.listaPacientes) {
            if (paciente.getId().equals(id) && paciente.getContrasena().equals(contrasena)) {
                return paciente;
            }
        }
        for (Medico medico : listaMedicos) {
            if (medico.getId().equals(id) && medico.getContrasena().equals(contrasena)) {
                return medico;
            }
        }
        for (Administrador admin : listaAdministradores) {
            if (admin.getId().equals(id) && admin.getContrasena().equals(contrasena)) {
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

    public LinkedList<Medico> buscarMedicoPorEspecialidad(Especialidad especialidad) {
        LinkedList<Medico> medicosEncontrados = new LinkedList<>();
        if (especialidad == null) {
            return medicosEncontrados;
        }
        for (Medico medico : listaMedicos) {
            if (medico.getEspecialidad() == especialidad) {
                medicosEncontrados.add(medico);
            }
        }
        return medicosEncontrados;
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

                // Validar los horarios antes de actualizarlos
                List<Horario> nuevosHorarios = newmedico.getHorarios();
                if (nuevosHorarios != null) {
                    // Verificar superposiciones de horarios
                    for (int i = 0; i < nuevosHorarios.size(); i++) {
                        for (int j = i + 1; j < nuevosHorarios.size(); j++) {
                            if (nuevosHorarios.get(i).coincideCon(nuevosHorarios.get(j))) {
                                throw new IllegalArgumentException("Hay horarios superposicionados");
                            }
                        }
                    }
                    medico.setHorarios(nuevosHorarios);
                }

                medico.setCertificado(newmedico.getCertificado());
                return medico;
            }
        }
        return null;
    }

    public Paciente buscarPaciente(String id) {
        for (Paciente paciente : listaPacientes) {
            if (paciente.getId().equals(id)) {
                return paciente;
            }
        }
        return null;
    }



    public boolean agregarHistorialMedico(String idPaciente, HistorialMedico historialMedico) {
        // Verificar que los parámetros no sean nulos
        if (idPaciente == null || historialMedico == null) {
            return false;
        }

        // Buscar el paciente con el ID proporcionado
        Paciente paciente = null;
        for (Paciente p : listaPacientes) {
            if (p.getId().equals(idPaciente)) {
                paciente = p;
                break;
            }
        }

        // Si no se encuentra el paciente, retornar false
        if (paciente == null) {
            return false;
        }

        // Agregar el historial médico a la lista
        try {
            listaDeHistorialesMedicos.add(historialMedico);
            paciente.setHistorialMedico((List<HistorialMedico>) historialMedico);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    public boolean actualizarHistorialMedico(String idPaciente, HistorialMedico historialMedico) {
        if (idPaciente == null || historialMedico == null) {
            return false;
        }

        // Buscar y actualizar el historial médico
        for (int i = 0; i < listaDeHistorialesMedicos.size(); i++) {
            if (listaDeHistorialesMedicos.get(i).getId().equals(idPaciente)) {
                listaDeHistorialesMedicos.set(i, historialMedico);

                // Actualizar el historial en el paciente correspondiente
                for (Paciente paciente : listaPacientes) {
                    if (paciente.getId().equals(idPaciente)) {
                        List<HistorialMedico> historialesActuales = paciente.getHistorialMedico();
                        if (historialesActuales == null) {
                            historialesActuales = new LinkedList<>();
                        }
                        historialesActuales.add(historialMedico);
                        paciente.setHistorialMedico(historialesActuales);
                        return true;
                    }
                }
            }
        }
        return false;
    }




    public LinkedList<HistorialMedico> obtenerHistorialMedicoPaciente(String idPaciente) {
        if (idPaciente == null) {
            // Retorna lista vacía si el ID es nulo
            return new LinkedList<>();
        }

        LinkedList<HistorialMedico> historialesPaciente = new LinkedList<>();
        for (HistorialMedico historial : listaDeHistorialesMedicos) {
            if (historial.getId().equals(idPaciente)) {
                historialesPaciente.add(historial);
            }
        }
        return historialesPaciente;
    }


    public List<Paciente> obtenerPacientes() {
        return new LinkedList<>(listaPacientes);
    }


    public Medico buscarMedico(String id) {
        for (Medico medico : listaMedicos) {
            if (medico.getId().equals(id)) {
                return medico;
            }
        }
        return null;
    }

    public Paciente actualizarPaciente(String numeroDocumento, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String email, String direccion) {
        //Buscar usuario
        Paciente paciente = buscarPaciente(numeroDocumento);
        if (paciente == null) {
            return null;
        }

        //Aplicar cambios
        if (nombre != null) {
            paciente.setNombres(nombre);
        }
        if (apellidos != null) {
            paciente.setApellidos(apellidos);
        }
        if (fechaNacimiento != null) {
            paciente.setFechaNacimiento(fechaNacimiento);
        }
        if (telefono != null) {
            paciente.setTelefono(telefono);
        }
        if (email != null) {
            paciente.setCorreo(email);
        }
        if (direccion != null) {
            paciente.setCorreo(direccion);
        }

        return paciente;
    }

    public boolean crearPaciente(Paciente paciente) {
        // Verificar que el paciente no sea nulo
        if (paciente == null) {
            System.out.println("paciente nulo");
            return false;

        }

        if(paciente.getEdad() < 0){
            System.out.println("edad menor a 0");
            return false;
        }

        //Verificar que no hay duplicados
        for (Paciente p : listaPacientes) {
            if (p.getId().equals(paciente.getId())) {
                System.out.println("paciente nulo");
                return false;
            }
        }

        // Agregar paciente
        listaPacientes.add(paciente);
        return true;
    }

    public boolean eliminarPaciente(String id) {
        Paciente paciente = buscarPaciente(id);
        if (paciente == null) {
            return false;

        }
        listaPacientes.remove(paciente);
        return true;
    }

}
