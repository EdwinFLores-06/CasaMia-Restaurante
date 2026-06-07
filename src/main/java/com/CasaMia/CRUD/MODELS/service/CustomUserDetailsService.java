package com.CasaMia.CRUD.MODELS.service;

import com.CasaMia.CRUD.MODELS.Usuario;
import com.CasaMia.CRUD.repository.UsuarioRepository;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

/**
 * Servicio personalizado de autenticación de usuarios.
 *
 * Esta clase implementa la interfaz UserDetailsService
 * de Spring Security para cargar los datos de un usuario
 * desde la base de datos durante el proceso de autenticación.
 *
 * También convierte los roles del usuario en autoridades
 * reconocidas por Spring Security.
 *
 * @author Fabricio
 * @version 1.0
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    /**
     * Repositorio utilizado para acceder
     * a la información de los usuarios.
     */
    @Autowired
    private UsuarioRepository usuarioRepo;

    /**
     * Carga un usuario utilizando su nombre de usuario.
     *
     * Este método es utilizado por Spring Security
     * para autenticar usuarios en el sistema.
     *
     * Si el usuario no existe, se lanza una excepción
     * UsernameNotFoundException.
     *
     * @param username Nombre de usuario ingresado.
     * @return Información de autenticación del usuario.
     * @throws UsernameNotFoundException
     * si el usuario no existe.
     */
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioRepo.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Usuario no encontrado"));

        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getRoles()
                        .stream()
                        .map(rol ->
                                new SimpleGrantedAuthority(
                                        rol.getNombre()))
                        .collect(Collectors.toList())
        );
    }
}