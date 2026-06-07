package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;

/**
 * Representa un producto dentro del sistema CasaMia.
 *
 * Esta entidad almacena la información de los productos
 * disponibles en el restaurante, incluyendo nombre,
 * descripción, precio, categoría y disponibilidad.
 *
 * También permite gestionar promociones y control
 * de inventario.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
public class Producto {

    /**
     * Identificador único del producto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Descripción detallada del producto.
     */
    @Column(length = 500)
    private String descripcion;

    /**
     * Ruta o nombre de la imagen del producto.
     */
    private String imagen;

    /**
     * Precio regular del producto.
     */
    private double precio;

    /**
     * Cantidad disponible en inventario.
     */
    private Integer cantidad;

    /**
     * Categoría del producto.
     *
     * Ejemplo:
     * bebidas, postres, platos fuertes.
     */
    private String categoria;

    /**
     * Indica si el producto está disponible.
     */
    private boolean disponible;

    /**
     * Indica si el producto tiene promoción activa.
     */
    private boolean promocion;

    /**
     * Precio promocional del producto.
     */
    private double precioPromocion;

    /**
     * Texto descriptivo de la promoción.
     */
    private String textoPromocion;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Producto() {
    }

    /**
     * Obtiene el identificador del producto.
     *
     * @return ID del producto.
     */
    public Long getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el identificador del producto.
     *
     * @param idProducto Nuevo ID del producto.
     */
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return Descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     *
     * @param descripcion Nueva descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la imagen del producto.
     *
     * @return Ruta o nombre de la imagen.
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la imagen del producto.
     *
     * @param imagen Nueva imagen del producto.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene el precio regular del producto.
     *
     * @return Precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio regular del producto.
     *
     * @param precio Nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad disponible del producto.
     *
     * @return Cantidad disponible.
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad disponible del producto.
     *
     * @param cantidad Nueva cantidad disponible.
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la categoría del producto.
     *
     * @return Categoría del producto.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del producto.
     *
     * @param categoria Nueva categoría.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Verifica si el producto está disponible.
     *
     * @return true si está disponible,
     * false en caso contrario.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Establece la disponibilidad del producto.
     *
     * @param disponible Nuevo estado de disponibilidad.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Verifica si el producto tiene promoción activa.
     *
     * @return true si tiene promoción,
     * false en caso contrario.
     */
    public boolean isPromocion() {
        return promocion;
    }

    /**
     * Establece el estado de promoción del producto.
     *
     * @param promocion Nuevo estado de promoción.
     */
    public void setPromocion(boolean promocion) {
        this.promocion = promocion;
    }

    /**
     * Obtiene el precio promocional del producto.
     *
     * @return Precio promocional.
     */
    public double getPrecioPromocion() {
        return precioPromocion;
    }

    /**
     * Establece el precio promocional del producto.
     *
     * @param precioPromocion Nuevo precio promocional.
     */
    public void setPrecioPromocion(double precioPromocion) {
        this.precioPromocion = precioPromocion;
    }

    /**
     * Obtiene el texto descriptivo de la promoción.
     *
     * @return Texto de promoción.
     */
    public String getTextoPromocion() {
        return textoPromocion;
    }

    /**
     * Establece el texto descriptivo de la promoción.
     *
     * @param textoPromocion Nuevo texto promocional.
     */
    public void setTextoPromocion(String textoPromocion) {
        this.textoPromocion = textoPromocion;
    }
}