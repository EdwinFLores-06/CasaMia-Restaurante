package com.CasaMia.CRUD.MODELS;

/**
 * Representa un elemento temporal dentro del carrito de compras.
 *
 * Esta clase almacena la información de un producto agregado
 * por el cliente, incluyendo nombre, precio y cantidad.
 *
 * También permite calcular automáticamente el subtotal
 * según la cantidad seleccionada.
 *
 * Esta clase no es una entidad persistente en la base de datos.
 *
 * @author Fabricio
 * @version 1.0
 */

public class Item {

    /**
     * Identificador del producto.
     */
    private Long idProducto;

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Precio unitario del producto.
     */
    private double precio;

    /**
     * Cantidad seleccionada del producto.
     */
    private int cantidad;

    /**
     * Constructor vacío.
     */
    public Item() {
    }

    /**
     * Constructor con parámetros para inicializar
     * los atributos del item.
     *
     * @param idProducto ID del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio unitario.
     * @param cantidad Cantidad seleccionada.
     */
    public Item(
            Long idProducto,
            String nombre,
            double precio,
            int cantidad
    ) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
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
     * Obtiene el precio unitario del producto.
     *
     * @return Precio unitario.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio unitario del producto.
     *
     * @param precio Nuevo precio unitario.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad seleccionada del producto.
     *
     * @return Cantidad seleccionada.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad seleccionada del producto.
     *
     * @param cantidad Nueva cantidad seleccionada.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Calcula el subtotal del item.
     *
     * El subtotal se obtiene multiplicando
     * el precio por la cantidad seleccionada.
     *
     * @return Subtotal calculado.
     */
    public double getSubtotal() {
        return precio * cantidad;
    }
}