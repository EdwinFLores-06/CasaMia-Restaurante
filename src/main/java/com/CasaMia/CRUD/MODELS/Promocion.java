package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una promoción dentro del sistema CasaMia.
 *
 * Esta entidad permite agrupar varios productos
 * en una oferta especial o combo promocional.
 *
 * La promoción almacena información como nombre,
 * descripción, precio del combo y estado de activación.
 *
 * Además, mantiene una relación muchos a muchos
 * con los productos incluidos en la promoción.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
public class Promocion {

    /**
     * Identificador único de la promoción.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromocion;

    /**
     * Nombre de la promoción.
     */
    private String nombre;

    /**
     * Descripción detallada de la promoción.
     */
    @Column(length = 500)
    private String descripcion;

    /**
     * Precio total del combo promocional.
     */
    private double precioCombo;
    
     /**
     * imagen que se mostrara a los usuarios.
     */
    private String imagen;
    /**
     * Indica si la promoción está activa.
     */
    private boolean activa;

    /**
     * Lista de productos incluidos en la promoción.
     */
    @ManyToMany
    @JoinTable(
            name = "promocion_productos",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos = new ArrayList<>();

    /**
     * Obtiene el identificador de la promoción.
     *
     * @return ID de la promoción.
     */
    public Long getIdPromocion() {
        return idPromocion;
    }

    /**
     * Establece el identificador de la promoción.
     *
     * @param idPromocion Nuevo ID de la promoción.
     */
    public void setIdPromocion(Long idPromocion) {
        this.idPromocion = idPromocion;
    }

    /**
     * Obtiene el nombre de la promoción.
     *
     * @return Nombre de la promoción.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la promoción.
     *
     * @param nombre Nuevo nombre de la promoción.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción de la promoción.
     *
     * @return Descripción de la promoción.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la promoción.
     *
     * @param descripcion Nueva descripción.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del combo promocional.
     *
     * @return Precio del combo.
     */
    public double getPrecioCombo() {
        return precioCombo;
    }

    /**
     * Establece el precio del combo promocional.
     *
     * @param precioCombo Nuevo precio del combo.
     */
    public void setPrecioCombo(double precioCombo) {
        this.precioCombo = precioCombo;
    }

    /**
     * Verifica si la promoción está activa.
     *
     * @return true si está activa,
     * false en caso contrario.
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * Establece el estado de activación de la promoción.
     *
     * @param activa Nuevo estado de la promoción.
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    /**
     * Obtiene la lista de productos asociados
     * a la promoción.
     *
     * @return Lista de productos promocionales.
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Establece la lista de productos asociados
     * a la promoción.
     *
     * @param productos Nueva lista de productos.
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
               
    }
    public String getImagen() {
    return imagen;
}

public void setImagen(String imagen) {
    this.imagen = imagen;
}
}