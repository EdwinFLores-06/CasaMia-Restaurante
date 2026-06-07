package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;

/**
 * Representa un plato disponible dentro del sistema CasaMia.
 *
 * Esta entidad almacena la información de los platos
 * ofrecidos en el restaurante, incluyendo nombre,
 * precio y disponibilidad.
 *
 * Cada plato pertenece a un menú específico.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
public class Plato {

    /**
     * Identificador único del plato.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlato;

    /**
     * Nombre del plato.
     */
    private String nombre;

    /**
     * Precio del plato.
     */
    private Double precio;

    /**
     * Indica si el plato está disponible.
     */
    private Boolean disponible;

    /**
     * Menú al que pertenece el plato.
     */
    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Plato() {}

    /**
     * Constructor con parámetros para inicializar
     * los atributos del plato.
     *
     * @param idPlato ID del plato.
     * @param nombre Nombre del plato.
     * @param precio Precio del plato.
     * @param disponible Disponibilidad del plato.
     * @param menu Menú asociado.
     */
    public Plato(Long idPlato,
                 String nombre,
                 Double precio,
                 Boolean disponible,
                 Menu menu) {

        this.idPlato = idPlato;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.menu = menu;
    }

    /**
     * Obtiene el identificador del plato.
     *
     * @return ID del plato.
     */
    public Long getIdPlato() {
        return idPlato;
    }

    /**
     * Establece el identificador del plato.
     *
     * @param idPlato Nuevo ID del plato.
     */
    public void setIdPlato(Long idPlato) {
        this.idPlato = idPlato;
    }

    /**
     * Obtiene el nombre del plato.
     *
     * @return Nombre del plato.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del plato.
     *
     * @param nombre Nuevo nombre del plato.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del plato.
     *
     * @return Precio del plato.
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del plato.
     *
     * @param precio Nuevo precio del plato.
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el estado de disponibilidad del plato.
     *
     * @return true si está disponible, false en caso contrario.
     */
    public Boolean getDisponible() {
        return disponible;
    }

    /**
     * Establece la disponibilidad del plato.
     *
     * @param disponible Nuevo estado de disponibilidad.
     */
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Obtiene el menú asociado al plato.
     *
     * @return Menú relacionado.
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * Establece el menú asociado al plato.
     *
     * @param menu Nuevo menú relacionado.
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}