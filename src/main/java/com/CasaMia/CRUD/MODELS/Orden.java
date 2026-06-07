package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una orden realizada dentro del sistema CasaMia.
 *
 * Esta entidad almacena la información general de una orden,
 * incluyendo fecha, estado, total y datos del cliente.
 *
 * También mantiene una relación con los detalles de la orden,
 * los cuales representan los productos solicitados.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
public class Orden {

    /**
     * Identificador único de la orden.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrden;

    /**
     * Fecha y hora en que fue creada la orden.
     */
    private LocalDateTime fecha;

    /**
     * Estado actual de la orden.
     *
     * Ejemplo:
     * pendiente, en preparación, entregada.
     */
    private String estado;

    /**
     * Total monetario de la orden.
     */
    private double total;

    /**
     * Nombre de usuario del cliente que realizó la orden.
     */
    private String clienteUsername;

    /**
     * Dirección de entrega de la orden.
     */
    private String direccion;

    /**
     * Número telefónico del cliente.
     */
    private String telefono;

    /**
     * Método de pago seleccionado.
     */
    private String pago;

    /**
     * Comentario adicional proporcionado por el cliente.
     */
    @Column(length = 500)
    private String comentario;

    /**
     * Lista de detalles asociados a la orden.
     */
    @OneToMany(
            mappedBy = "orden",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DetalleOrden> detalles =
            new ArrayList<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Orden() {
    }

    /**
     * Obtiene el identificador de la orden.
     *
     * @return ID de la orden.
     */
    public Long getIdOrden() {
        return idOrden;
    }

    /**
     * Establece el identificador de la orden.
     *
     * @param idOrden Nuevo ID de la orden.
     */
    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    /**
     * Obtiene la fecha de la orden.
     *
     * @return Fecha y hora de la orden.
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la orden.
     *
     * @param fecha Nueva fecha de la orden.
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el estado actual de la orden.
     *
     * @return Estado de la orden.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la orden.
     *
     * @param estado Nuevo estado de la orden.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el total monetario de la orden.
     *
     * @return Total de la orden.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece el total monetario de la orden.
     *
     * @param total Nuevo total de la orden.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Obtiene el nombre de usuario del cliente.
     *
     * @return Nombre de usuario del cliente.
     */
    public String getClienteUsername() {
        return clienteUsername;
    }

    /**
     * Establece el nombre de usuario del cliente.
     *
     * @param clienteUsername Nuevo usuario del cliente.
     */
    public void setClienteUsername(String clienteUsername) {
        this.clienteUsername = clienteUsername;
    }

    /**
     * Obtiene la dirección de entrega.
     *
     * @return Dirección del cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de entrega.
     *
     * @param direccion Nueva dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el número telefónico del cliente.
     *
     * @return Número telefónico.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número telefónico del cliente.
     *
     * @param telefono Nuevo número telefónico.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el método de pago.
     *
     * @return Método de pago seleccionado.
     */
    public String getPago() {
        return pago;
    }

    /**
     * Establece el método de pago.
     *
     * @param pago Nuevo método de pago.
     */
    public void setPago(String pago) {
        this.pago = pago;
    }

    /**
     * Obtiene el comentario adicional de la orden.
     *
     * @return Comentario del cliente.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Establece el comentario adicional de la orden.
     *
     * @param comentario Nuevo comentario.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Obtiene la lista de detalles de la orden.
     *
     * @return Lista de detalles asociados.
     */
    public List<DetalleOrden> getDetalles() {
        return detalles;
    }

    /**
     * Establece la lista de detalles de la orden.
     *
     * @param detalles Nueva lista de detalles.
     */
    public void setDetalles(List<DetalleOrden> detalles) {
        this.detalles = detalles;
    }
}