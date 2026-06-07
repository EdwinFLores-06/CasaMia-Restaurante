package com.CasaMia.CRUD.MODELS;

/**
 * Representa un elemento dentro del carrito de compras.
 *
 * Esta clase almacena un producto junto con la cantidad
 * seleccionada por el cliente.
 *
 * También permite calcular el subtotal correspondiente
 * multiplicando el precio del producto por la cantidad.
 *
 * Esta clase es utilizada para gestionar temporalmente
 * los productos agregados al carrito.
 *
 * @author Flore
 * @version 1.0
 */

public class ItemCarrito {

    /**
     * Producto asociado al carrito.
     */
    private Producto producto;

    /**
     * Cantidad seleccionada del producto.
     */
    private int cantidad;

    /**
     * Calcula el subtotal del producto dentro del carrito.
     *
     * El subtotal se obtiene multiplicando el precio
     * del producto por la cantidad seleccionada.
     *
     * @return Subtotal calculado.
     */
    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    /**
     * Obtiene el producto asociado.
     *
     * @return Producto del carrito.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto asociado al carrito.
     *
     * @param producto Producto seleccionado.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Obtiene la cantidad seleccionada.
     *
     * @return Cantidad del producto.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad seleccionada.
     *
     * @param cantidad Nueva cantidad del producto.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}