package com.CasaMia.CRUD.MODELS;

import jakarta.persistence.*;
import java.util.List;

/**
 * Representa un usuario dentro del sistema CasaMia.
 *
 * Esta entidad almacena la información necesaria
 * para la autenticación y autorización de usuarios.
 *
 * Cada usuario posee credenciales de acceso,
 * un estado de habilitación y una lista de roles
 * asociados para definir sus permisos.
 *
 * @author Fabricio
 * @version 1.0
 */

@Entity
@Table(name = "usuarios")
public class Usuario {

    /**
     * Identificador único del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de usuario utilizado para iniciar sesión.
     */
    private String username;

    /**
     * Contraseña del usuario.
     */
    private String password;

    /**
     * Indica si el usuario está habilitado.
     */
    private boolean enabled;

    /**
     * Lista de roles asociados al usuario.
     *
     * La relación es muchos a muchos,
     * ya que un usuario puede tener varios roles
     * y un rol puede pertenecer a varios usuarios.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_roles",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private List<Rol> roles;

    /**
     * Obtiene el identificador del usuario.
     *
     * @return ID del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param id Nuevo ID del usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return Nombre de usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param username Nuevo nombre de usuario.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password Nueva contraseña.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Verifica si el usuario está habilitado.
     *
     * @return true si está habilitado,
     * false en caso contrario.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Establece el estado de habilitación del usuario.
     *
     * @param enabled Nuevo estado del usuario.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Obtiene la lista de roles asociados al usuario.
     *
     * @return Lista de roles.
     */
    public List<Rol> getRoles() {
        return roles;
    }

    /**
     * Establece la lista de roles asociados al usuario.
     *
     * @param roles Nueva lista de roles.
     */
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}