package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;

/**
 * Representa el detalle de una orden dentro del sistema CasaMia.
 *
 * Esta entidad almacena la información de los productos
 * asociados a una orden, incluyendo nombre y precio.
 *
 * Cada detalle pertenece a una única orden mediante
 * una relación muchos a uno.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
public class DetalleOrden {

    /**
     * Identificador único del detalle de la orden.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    /**
     * Nombre del producto incluido en la orden.
     */
    private String nombreProducto;

    /**
     * Precio del producto.
     */
    private double precio;

    /**
     * Orden asociada al detalle.
     */
    @ManyToOne
    @JoinColumn(name = "id_orden")
    private Orden orden;

    /**
     * Obtiene el identificador del detalle.
     *
     * @return ID del detalle de la orden.
     */
    public Long getIdDetalle() {
        return idDetalle;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombreProducto Nombre del producto.
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return Precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio Precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la orden asociada.
     *
     * @return Orden relacionada con el detalle.
     */
    public Orden getOrden() {
        return orden;
    }

    /**
     * Establece la orden asociada.
     *
     * @param orden Orden relacionada.
     */
    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}