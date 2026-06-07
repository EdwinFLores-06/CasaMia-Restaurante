package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;

/**
 * Representa una mesa dentro del restaurante CasaMia.
 *
 * Esta entidad almacena la información relacionada
 * con las mesas disponibles en el restaurante,
 * incluyendo su número y estado actual.
 *
 * El estado de la mesa puede indicar si está:
 * disponible, ocupada o reservada.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
public class Mesa {

    /**
     * Identificador único de la mesa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMesa;

    /**
     * Número identificador de la mesa.
     */
    private Integer numero;

    /**
     * Estado actual de la mesa.
     */
    private String estado;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Mesa() {}

    /**
     * Constructor con parámetros para inicializar
     * los atributos de la mesa.
     *
     * @param idMesa ID de la mesa.
     * @param numero Número de la mesa.
     * @param estado Estado actual de la mesa.
     */
    public Mesa(Long idMesa, Integer numero, String estado) {
        this.idMesa = idMesa;
        this.numero = numero;
        this.estado = estado;
    }

    /**
     * Obtiene el identificador de la mesa.
     *
     * @return ID de la mesa.
     */
    public Long getIdMesa() {
        return idMesa;
    }

    /**
     * Establece el identificador de la mesa.
     *
     * @param idMesa Nuevo ID de la mesa.
     */
    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    /**
     * Obtiene el número de la mesa.
     *
     * @return Número de la mesa.
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Establece el número de la mesa.
     *
     * @param numero Nuevo número de la mesa.
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el estado actual de la mesa.
     *
     * @return Estado de la mesa.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual de la mesa.
     *
     * @param estado Nuevo estado de la mesa.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}