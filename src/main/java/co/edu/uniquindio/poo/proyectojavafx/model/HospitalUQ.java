package co.edu.uniquindio.poo.proyectojavafx.model;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class HospitalUQ {
    private String nombre;
    private static LinkedList<Persona> listaPersonas;
    private static LinkedList<Medico> listaMedicos;
    private static LinkedList<Paciente> listaPacientes;
    private static LinkedList<Administrador> listaAdministradores;
    private LinkedList<HistorialMedico> listaDeHistorialesMedicos;
    private static HospitalUQ instancia;


    public HospitalUQ(String nombre) {
        this.nombre = nombre;
        this.listaMedicos = new LinkedList<>();
        this.listaPacientes = new LinkedList<>();
        this.listaAdministradores = new LinkedList<>();
        this.listaDeHistorialesMedicos = new LinkedList<>();
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
                "pacientePrueba",                                   // id
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
        horariosPrueba.add(new Horario(DayOfWeek.MONDAY, LocalTime.parse("08:00"), LocalTime.parse("12:00")  ));

        List<Horario> horariosMedico = new ArrayList<>();
        List<Cita> citasMedico = new ArrayList<>();

        List<HistorialMedico> historialesMedico = new ArrayList<>();
        Medico medicoPrueba = new Medico(
                "medicoprueba",                           // id
                Genero.MASCULINO,                   // genero
                "Carlos",                           // nombres
                "Sanchez",                          // apellidos
                45,                                 // edad
                "3001234567",                       // telefono
                "carlos.andrade@hospital.com",      // correo
                "Av. Siempre Viva 742",             // direccion
                "1234",                    // contrasena
                "MLIC-98765",                       // NLicencia
                true,                               // certificado (true porque está certificado)
                horariosMedico,                     // horarios (la lista que creaste arriba)
                "Consultorio 301",                  // ubicacion
                Estado.ACTIVO,                      // estado (asumo un enum Estado)
                Especialidad.CARDIOLOGO,           // especialidad (asumo un enum Especialidad)
                citasMedico,                        // citasAsignadas (la lista que creaste arriba)
                historialesMedico                   // historialesPacientes (la lista que creaste arriba)
        );
        listaMedicos.add(medicoPrueba);
        Administrador adminPrueba = new Administrador(
                "admin",                           // id (por ejemplo, un ID único para administradores)
                Genero.FEMENINO,                        // genero (puedes usar MASCULINO, FEMENINO u OTRO)
                "Ruben",                              // nombres
                "Sanchez",                           // apellidos
                17,                                 // edad
                "3245870864",                       // telefono
                "rubens.sancheze@uqvirtual.edu.co",          // correo
                "Mi casa bro",                   // direccion
                "admin"                         // contrasena
        );
        listaAdministradores.add(adminPrueba);
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
        return new LinkedList<>(listaPacientes) ;
    }


    public Medico buscarMedico(String id) {
        for (Medico medico : listaMedicos) {
            if (medico.getId().equals(id)) {
                return medico;
            }
        }
        return null;
    }

    public Paciente actualizarPaciente(Paciente paciente) {
        if (paciente == null || paciente.getId() == null) {
            return null;
        }

        //Buscar el paciente y actualizar los datos
        for (int i = 0; i < listaPacientes.size(); i++) {
            if (listaPacientes.get(i).getId().equals(paciente.getId())) {
                listaPacientes.set(i, paciente);
                return paciente;
            }
        }

        // Si el paciente no existe, lo agregamos a la lista
        listaPacientes.add(paciente);
        return paciente;
    }
    public Paciente actualizarPaciente(String numeroDocumento, String nombre, String apellidos,
                                       LocalDate fechaNacimiento, String telefono, String email) {
        if (numeroDocumento == null) {
            return null;
        }

        // Buscar el paciente por número de documento
        for (Paciente paciente : listaPacientes) {
            if (paciente.getId().equals(numeroDocumento)) {
                // Actualizar solo los campos que no son null
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

    public static boolean crearPaciente(Paciente paciente) {
        // Validar que el paciente no sea null
        if (paciente == null) {
            return false;
        }

        // Validar que los datos obligatorios no sean null o vacíos
        if (paciente.getId() == null || paciente.getId().trim().isEmpty() ||
                paciente.getNombres() == null || paciente.getNombres().trim().isEmpty() ||
                paciente.getApellidos() == null || paciente.getApellidos().trim().isEmpty()) {
            return false;
        }

        // Verificar que no exista otro paciente con el mismo número de documento
        for (Paciente p : listaPacientes) {
            if (p.getId().equals(paciente.getId())) {
                return false;
            }
        }

        // Inicializar la lista de historiales médicos si es null
        if (paciente.getHistorialMedico() == null) {
            paciente.setHistorialMedico(new LinkedList<>());
        }

        // Agregar el paciente a la lista
        return listaPacientes.add(paciente);
    }

}
