/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

import com.CasaMia.CRUD.MODELS.Rol;
import com.CasaMia.CRUD.MODELS.Usuario;
import com.CasaMia.CRUD.repository.RolRepository;
import com.CasaMia.CRUD.repository.UsuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private RolRepository rolRepo;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String registrar(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String confirmPassword
    ) {

        if (!password.equals(confirmPassword)) {
            return "redirect:/registro?password";
        }

        if (usuarioRepo.findByUsername(username).isPresent()) {
            return "redirect:/registro?existe";
        }

        Rol rolCliente = rolRepo.findByNombre("ROLE_CLIENTE")
                .orElseGet(() -> {
                    Rol nuevoRol = new Rol();
                    nuevoRol.setNombre("ROLE_CLIENTE");
                    return rolRepo.save(nuevoRol);
                });

        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(encoder.encode(password));
        usuario.setEnabled(true);
        usuario.setRoles(List.of(rolCliente));

        usuarioRepo.save(usuario);

        return "redirect:/login?registrado";
    }
}
