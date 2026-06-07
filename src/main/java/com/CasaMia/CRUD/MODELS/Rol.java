package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;

/**
 * Representa un rol dentro del sistema CasaMia.
 *
 * Esta entidad se utiliza para gestionar los permisos
 * y niveles de acceso de los usuarios del sistema.
 *
 * Un rol puede corresponder a diferentes tipos
 * de usuarios, por ejemplo:
 * administrador, empleado o cliente.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
@Table(name = "roles")
public class Rol {

    /**
     * Identificador único del rol.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del rol.
     */
    private String nombre;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Rol() {
    }

    /**
     * Constructor con parámetro para inicializar
     * el nombre del rol.
     *
     * @param nombre Nombre del rol.
     */
    public Rol(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador del rol.
     *
     * @return ID del rol.
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtiene el nombre del rol.
     *
     * @return Nombre del rol.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del rol.
     *
     * @param nombre Nuevo nombre del rol.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}