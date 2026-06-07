package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Representa un pedido realizado dentro del sistema CasaMia.
 *
 * Esta entidad almacena la información principal de un pedido,
 * incluyendo el total, estado y fecha de creación.
 *
 * Además, mantiene relaciones con el cliente que realizó
 * el pedido y la mesa asociada.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
public class Pedido {

    /**
     * Identificador único del pedido.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    /**
     * Total monetario del pedido.
     */
    private Double total;

    /**
     * Estado actual del pedido.
     *
     * Ejemplo:
     * pendiente, preparado, entregado.
     */
    private String estado;

    /**
     * Fecha y hora en que fue realizado el pedido.
     */
    private LocalDateTime fechaHora;

    /**
     * Cliente asociado al pedido.
     */
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    /**
     * Mesa asociada al pedido.
     */
    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Pedido() {}

    /**
     * Constructor con parámetros para inicializar
     * los atributos del pedido.
     *
     * @param idPedido ID del pedido.
     * @param total Total del pedido.
     * @param estado Estado del pedido.
     * @param fechaHora Fecha y hora del pedido.
     * @param cliente Cliente asociado.
     * @param mesa Mesa asociada.
     */
    public Pedido(Long idPedido,
                  Double total,
                  String estado,
                  LocalDateTime fechaHora,
                  Cliente cliente,
                  Mesa mesa) {

        this.idPedido = idPedido;
        this.total = total;
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    /**
     * Obtiene el identificador del pedido.
     *
     * @return ID del pedido.
     */
    public Long getIdPedido() {
        return idPedido;
    }

    /**
     * Establece el identificador del pedido.
     *
     * @param idPedido Nuevo ID del pedido.
     */
    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * Obtiene el total monetario del pedido.
     *
     * @return Total del pedido.
     */
    public Double getTotal() {
        return total;
    }

    /**
     * Establece el total monetario del pedido.
     *
     * @param total Nuevo total del pedido.
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * Obtiene el estado actual del pedido.
     *
     * @return Estado del pedido.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del pedido.
     *
     * @param estado Nuevo estado del pedido.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha y hora del pedido.
     *
     * @return Fecha y hora del pedido.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora del pedido.
     *
     * @param fechaHora Nueva fecha y hora.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el cliente asociado al pedido.
     *
     * @return Cliente relacionado.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado al pedido.
     *
     * @param cliente Nuevo cliente relacionado.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la mesa asociada al pedido.
     *
     * @return Mesa relacionada.
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * Establece la mesa asociada al pedido.
     *
     * @param mesa Nueva mesa relacionada.
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}