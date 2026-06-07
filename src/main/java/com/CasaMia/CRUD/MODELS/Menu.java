package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;
import java.util.List;

/**
 * Representa un menú dentro del sistema CasaMia.
 *
 * Esta entidad almacena la información principal de un menú,
 * incluyendo su nombre, descripción y tipo.
 *
 * Además, mantiene una relación con los platos
 * que pertenecen al menú.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
public class Menu {

    /**
     * Identificador único del menú.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMenu;

    /**
     * Nombre del menú.
     */
    private String nombre;

    /**
     * Descripción del menú.
     */
    private String descripcion;

    /**
     * Tipo de menú.
     *
     * Ejemplo:
     * desayuno, almuerzo, cena, bebidas, postres.
     */
    private String tipo;

    /**
     * Lista de platos asociados al menú.
     */
    @OneToMany(mappedBy = "menu")
    private List<Plato> platos;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Menu() {}

    /**
     * Constructor con parámetros para inicializar
     * los atributos del menú.
     *
     * @param idMenu ID del menú.
     * @param nombre Nombre del menú.
     * @param descripcion Descripción del menú.
     * @param tipo Tipo de menú.
     */
    public Menu(Long idMenu,
                String nombre,
                String descripcion,
                String tipo) {

        this.idMenu = idMenu;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    /**
     * Obtiene el identificador del menú.
     *
     * @return ID del menú.
     */
    public Long getIdMenu() {
        return idMenu;
    }

    /**
     * Establece el identificador del menú.
     *
     * @param idMenu Nuevo ID del menú.
     */
    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    /**
     * Obtiene el nombre del menú.
     *
     * @return Nombre del menú.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del menú.
     *
     * @param nombre Nuevo nombre del menú.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del menú.
     *
     * @return Descripción del menú.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del menú.
     *
     * @param descripcion Nueva descripción del menú.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el tipo de menú.
     *
     * @return Tipo de menú.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de menú.
     *
     * @param tipo Nuevo tipo de menú.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la lista de platos asociados.
     *
     * @return Lista de platos del menú.
     */
    public List<Plato> getPlatos() {
        return platos;
    }

    /**
     * Establece la lista de platos asociados.
     *
     * @param platos Nueva lista de platos.
     */
    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }
}