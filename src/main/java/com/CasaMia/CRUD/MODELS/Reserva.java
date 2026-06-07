package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Representa una reserva realizada dentro del sistema CasaMia.
 *
 * Esta entidad almacena la información relacionada
 * con las reservas de mesas realizadas por los clientes,
 * incluyendo fecha, hora, cantidad de personas y estado.
 *
 * Permite gestionar la disponibilidad y organización
 * de las mesas del restaurante.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
public class Reserva {

    /**
     * Identificador único de la reserva.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    /**
     * Nombre de la persona que realizó la reserva.
     */
    private String nombre;

    /**
     * Fecha programada para la reserva.
     */
    private LocalDate fecha;

    /**
     * Hora programada para la reserva.
     */
    private LocalTime hora;

    /**
     * Cantidad de personas incluidas en la reserva.
     */
    private Integer personas;

    /**
     * Número de mesa asignada.
     */
    private Integer mesa;

    /**
     * Estado actual de la reserva.
     *
     * Ejemplo:
     * pendiente, confirmada, cancelada.
     */
    private String estado;

    /**
     * Obtiene el identificador de la reserva.
     *
     * @return ID de la reserva.
     */
    public Long getIdReserva() {
        return idReserva;
    }

    /**
     * Obtiene el nombre de la persona
     * que realizó la reserva.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona
     * que realizó la reserva.
     *
     * @param nombre Nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de la reserva.
     *
     * @return Fecha de la reserva.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la reserva.
     *
     * @param fecha Nueva fecha de reserva.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de la reserva.
     *
     * @return Hora de la reserva.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora de la reserva.
     *
     * @param hora Nueva hora de reserva.
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Obtiene la cantidad de personas
     * incluidas en la reserva.
     *
     * @return Cantidad de personas.
     */
    public Integer getPersonas() {
        return personas;
    }

    /**
     * Establece la cantidad de personas
     * incluidas en la reserva.
     *
     * @param personas Nueva cantidad de personas.
     */
    public void setPersonas(Integer personas) {
        this.personas = personas;
    }

    /**
     * Obtiene el número de mesa asignada.
     *
     * @return Número de mesa.
     */
    public Integer getMesa() {
        return mesa;
    }

    /**
     * Establece el número de mesa asignada.
     *
     * @param mesa Nuevo número de mesa.
     */
    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    /**
     * Obtiene el estado actual de la reserva.
     *
     * @return Estado de la reserva.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual de la reserva.
     *
     * @param estado Nuevo estado de la reserva.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}