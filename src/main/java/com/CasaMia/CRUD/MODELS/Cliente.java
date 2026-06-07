/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;

/**
 * Representa un cliente dentro del sistema CasaMia.
 *
 * Esta entidad almacena la información básica de los clientes,
 * incluyendo su identificador, nombre y correo electrónico.
 *
 * La clase es utilizada para gestionar pedidos, reservas
 * y otras operaciones relacionadas con clientes.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
public class Cliente {

    /**
     * Identificador único del cliente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    /**
     * Nombre completo del cliente.
     */
    private String nombre;

    /**
     * Correo electrónico del cliente.
     */
    private String correo;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Cliente() {}

    /**
     * Constructor con parámetros para inicializar
     * los atributos del cliente.
     *
     * @param idCliente ID del cliente.
     * @param nombre Nombre del cliente.
     * @param correo Correo electrónico del cliente.
     */
    public Cliente(Long idCliente, String nombre, String correo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo = correo;
    }

    /**
     * Obtiene el identificador del cliente.
     *
     * @return ID del cliente.
     */
    public Long getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador del cliente.
     *
     * @param idCliente Nuevo ID del cliente.
     */
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre Nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return Correo del cliente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del cliente.
     *
     * @param correo Nuevo correo del cliente.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}