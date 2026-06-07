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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/usuarios")
public class AdminUsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private RolRepository rolRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String mostrarUsuarios(Model model) {

        model.addAttribute("usuarios", usuarioRepo.findAll());

        return "admin-usuarios";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(
            @RequestParam String username,
            @RequestParam String password
    ) {

        if (usuarioRepo.findByUsername(username).isPresent()) {
            return "redirect:/admin/usuarios?existe";
        }

        Rol rolEmpleado = rolRepo.findByNombre("ROLE_EMPLEADO")
                .orElseGet(() -> {
                    Rol rol = new Rol();
                    rol.setNombre("ROLE_EMPLEADO");
                    return rolRepo.save(rol);
                });

        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(passwordEncoder.encode(password));
        usuario.setEnabled(true);
        usuario.setRoles(List.of(rolEmpleado));

        usuarioRepo.save(usuario);

        return "redirect:/admin/usuarios?creado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {

        usuarioRepo.deleteById(id);

        return "redirect:/admin/usuarios?eliminado";
    }

    @GetMapping("/desactivar/{id}")
    public String desactivarUsuario(@PathVariable Long id) {

        Usuario usuario = usuarioRepo.findById(id).orElse(null);

        if (usuario != null) {
            usuario.setEnabled(false);
            usuarioRepo.save(usuario);
        }

        return "redirect:/admin/usuarios";
    }

    @GetMapping("/activar/{id}")
    public String activarUsuario(@PathVariable Long id) {

        Usuario usuario = usuarioRepo.findById(id).orElse(null);

        if (usuario != null) {
            usuario.setEnabled(true);
            usuarioRepo.save(usuario);
        }

        return "redirect:/admin/usuarios";
    }
}
