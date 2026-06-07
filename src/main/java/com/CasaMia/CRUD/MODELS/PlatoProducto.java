package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;

/**
 * Representa la relación entre un plato y los productos
 * utilizados para su preparación dentro del sistema CasaMia.
 *
 * Esta entidad permite registrar qué productos utiliza
 * un plato y en qué cantidad son consumidos.
 *
 * Se utiliza para gestionar el inventario y controlar
 * los insumos necesarios para cada plato.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
public class PlatoProducto {

    /**
     * Identificador único de la relación.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cantidad del producto utilizada en el plato.
     */
    private Integer cantidadUsa;

    /**
     * Plato asociado a la relación.
     */
    @ManyToOne
    @JoinColumn(name = "id_plato")
    private Plato plato;

    /**
     * Producto utilizado en el plato.
     */
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    /**
     * Constructor vacío requerido por JPA.
     */
    public PlatoProducto() {}

    /**
     * Constructor con parámetros para inicializar
     * los atributos de la relación.
     *
     * @param id ID de la relación.
     * @param cantidadUsa Cantidad utilizada del producto.
     * @param plato Plato asociado.
     * @param producto Producto asociado.
     */
    public PlatoProducto(Long id,
                         Integer cantidadUsa,
                         Plato plato,
                         Producto producto) {

        this.id = id;
        this.cantidadUsa = cantidadUsa;
        this.plato = plato;
        this.producto = producto;
    }

    /**
     * Obtiene el identificador de la relación.
     *
     * @return ID de la relación.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la relación.
     *
     * @param id Nuevo ID de la relación.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la cantidad del producto utilizada.
     *
     * @return Cantidad utilizada.
     */
    public Integer getCantidadUsa() {
        return cantidadUsa;
    }

    /**
     * Establece la cantidad del producto utilizada.
     *
     * @param cantidadUsa Nueva cantidad utilizada.
     */
    public void setCantidadUsa(Integer cantidadUsa) {
        this.cantidadUsa = cantidadUsa;
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
     * @param plato Nuevo plato relacionado.
     */
    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    /**
     * Obtiene el producto asociado.
     *
     * @return Producto relacionado.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto asociado.
     *
     * @param producto Nuevo producto relacionado.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}