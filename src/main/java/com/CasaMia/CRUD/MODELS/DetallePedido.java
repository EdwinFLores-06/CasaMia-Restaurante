/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;

/**
 * Representa el detalle de un pedido dentro del sistema CasaMia.
 *
 * Esta entidad almacena los platos asociados a un pedido,
 * incluyendo la cantidad solicitada y el subtotal generado.
 *
 * Cada detalle pertenece a un pedido y está relacionado
 * con un plato específico del menú.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
public class DetallePedido {

    /**
     * Identificador único del detalle del pedido.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    /**
     * Cantidad de platos solicitados.
     */
    private Integer cantidad;

    /**
     * Subtotal calculado del detalle del pedido.
     */
    private Double subtotal;

    /**
     * Pedido asociado al detalle.
     */
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    /**
     * Plato asociado al detalle.
     */
    @ManyToOne
    @JoinColumn(name = "id_plato")
    private Plato plato;

    /**
     * Constructor vacío requerido por JPA.
     */
    public DetallePedido() {}

    /**
     * Constructor con parámetros para inicializar
     * los atributos del detalle del pedido.
     *
     * @param idDetalle ID del detalle.
     * @param cantidad Cantidad de platos.
     * @param subtotal Subtotal calculado.
     * @param pedido Pedido asociado.
     * @param plato Plato asociado.
     */
    public DetallePedido(Long idDetalle,
                         Integer cantidad,
                         Double subtotal,
                         Pedido pedido,
                         Plato plato) {

        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.pedido = pedido;
        this.plato = plato;
    }

    /**
     * Obtiene el identificador del detalle.
     *
     * @return ID del detalle del pedido.
     */
    public Long getIdDetalle() {
        return idDetalle;
    }

    /**
     * Establece el identificador del detalle.
     *
     * @param idDetalle Nuevo ID del detalle.
     */
    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    /**
     * Obtiene la cantidad de platos solicitados.
     *
     * @return Cantidad de platos.
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de platos solicitados.
     *
     * @param cantidad Nueva cantidad de platos.
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el subtotal del detalle.
     *
     * @return Subtotal del pedido.
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /**
     * Establece el subtotal del detalle.
     *
     * @param subtotal Nuevo subtotal.
     */
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Obtiene el pedido asociado.
     *
     * @return Pedido relacionado.
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * Establece el pedido asociado.
     *
     * @param pedido Pedido relacionado.
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * Obtiene el plato asociado.
     *
     * @return Plato relacionado.
     */
    public Plato getPlato() {
        return plato;
    }

    /**
     * Establece el plato asociado.
     *
     * @param plato Plato relacionado.
     */
    public void setPlato(Plato plato) {
        this.plato = plato;
    }
}
