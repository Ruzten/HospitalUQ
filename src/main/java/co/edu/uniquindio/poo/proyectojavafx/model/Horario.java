package co.edu.uniquindio.poo.proyectojavafx.model;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Horario {
    private DayOfWeek diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private boolean disponible;
    private static final int DURACION_CITA_MINUTOS = 30;


    public Horario(DayOfWeek diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        if (horaInicio.isAfter(horaFin)) {
            throw new IllegalArgumentException("La hora de inicio debe ser anterior a la hora de fin");
        }
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponible = true;
    }

    //Constructor para que acepte la informaicón en string
    public static Horario fromString(String diaSemana, String horaInicio, String horaFin) {
        DayOfWeek dia = DayOfWeek.valueOf(diaSemana.toUpperCase());
        LocalTime inicio = LocalTime.parse(horaInicio);
        LocalTime fin = LocalTime.parse(horaFin);
        return new Horario(dia, inicio, fin);
    }

    public DayOfWeek getDiaSemana() {
        return diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //Metodo para verificar si dos horarios cruzados
    public boolean coincideCon(Horario otro) {
        if (!this.diaSemana.equals(otro.diaSemana)) {
            return false;
        }
        return !(this.horaFin.isBefore(otro.horaInicio) ||
                this.horaInicio.isAfter(otro.horaFin));
    }

    //Metodo para verificar si hay horarios disponibles
    public List<LocalTime> obtenerHorariosDisponibles() {
        List<LocalTime> horarios = new ArrayList<>();
        LocalTime hora = horaInicio;
        while (hora.plus(DURACION_CITA_MINUTOS, ChronoUnit.MINUTES).isBefore(horaFin) ||
                hora.plus(DURACION_CITA_MINUTOS, ChronoUnit.MINUTES).equals(horaFin)) {
            horarios.add(hora);
            hora = hora.plus(DURACION_CITA_MINUTOS, ChronoUnit.MINUTES);
        }
        return horarios;
    }

    //Metodo para verificar si una cita esta en el horario
    public boolean estaEnHorario(LocalDateTime fechaHora) {
        return fechaHora.getDayOfWeek() == this.diaSemana &&
                !fechaHora.toLocalTime().isBefore(this.horaInicio) &&
                !fechaHora.toLocalTime().isAfter(this.horaFin);
    }

    public Duration getDuracion() {
        return Duration.between(horaInicio, horaFin);
    }

    public boolean estaOcupado() {
        LocalDateTime ahora = LocalDateTime.now();
        DayOfWeek diaActual = ahora.getDayOfWeek();
        LocalTime horaActual = ahora.toLocalTime();

        // Primero verificamos si es el mismo día
        if (this.diaSemana.equals(diaActual)) {
            // Verificamos si la hora actual está dentro del rango del horario
            return !horaActual.isBefore(this.horaInicio) &&
                    !horaActual.isAfter(this.horaFin);
        }

        return false;
    }

}
