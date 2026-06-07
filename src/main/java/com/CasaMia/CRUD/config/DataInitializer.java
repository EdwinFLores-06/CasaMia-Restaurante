/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.config;


import com.CasaMia.CRUD.MODELS.Rol;
import com.CasaMia.CRUD.MODELS.Usuario;
import com.CasaMia.CRUD.repository.RolRepository;
import com.CasaMia.CRUD.repository.UsuarioRepository;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(
            UsuarioRepository usuarioRepo,
            RolRepository rolRepo,
            PasswordEncoder encoder) {

        return args -> {

            // =========================
            // CREAR ROLE_ADMIN
            // =========================

            Rol rolAdmin = rolRepo
                    .findByNombre("ROLE_ADMIN")
                    .orElseGet(() -> {

                        Rol nuevoRol = new Rol();
                        nuevoRol.setNombre("ROLE_ADMIN");

                        return rolRepo.save(nuevoRol);
                    });
            
             // =========================
            // CREAR ROLE_EMPLEADO
            // =========================

            Rol rolEmpleado = rolRepo
            .findByNombre("ROLE_EMPLEADO")
            .orElseGet(() -> {

                Rol nuevoRol = new Rol();
                nuevoRol.setNombre("ROLE_EMPLEADO");

                return rolRepo.save(nuevoRol);
            });
            // =========================
            // CREAR ROLE_CLIENTE
            // =========================

            Rol rolCliente = rolRepo
                    .findByNombre("ROLE_CLIENTE")
                    .orElseGet(() -> {

                        Rol nuevoRol = new Rol();
                        nuevoRol.setNombre("ROLE_CLIENTE");

                        return rolRepo.save(nuevoRol);
                    });

            // =========================
            // CREAR ADMIN
            // =========================

            if (usuarioRepo.findByUsername("admin").isEmpty()) {

                Usuario admin = new Usuario();

                admin.setUsername("admin");

                admin.setPassword(
                        encoder.encode("admin123")
                );

                admin.setEnabled(true);

                admin.setRoles(
                        List.of(rolAdmin)
                );

                usuarioRepo.save(admin);

                System.out.println("✅ ADMIN creado");
            }

            // =========================
            // CREAR CLIENTE
            // =========================

            if (usuarioRepo.findByUsername("cliente").isEmpty()) {

                Usuario cliente = new Usuario();

                cliente.setUsername("cliente");

                cliente.setPassword(
                        encoder.encode("admin123")
                );

                cliente.setEnabled(true);

                cliente.setRoles(
                        List.of(rolCliente)
                );

                usuarioRepo.save(cliente);

                System.out.println("✅ CLIENTE creado");
            }

        };
    }
}