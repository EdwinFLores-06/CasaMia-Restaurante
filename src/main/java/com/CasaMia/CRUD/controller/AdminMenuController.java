/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

import com.CasaMia.CRUD.MODELS.Producto;
import com.CasaMia.CRUD.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/menu")
public class AdminMenuController {

    @Autowired
    private ProductoRepository productoRepo;

    // MOSTRAR MENU ADMIN
    @GetMapping
    public String mostrarMenu(Model model) {

        model.addAttribute(
                "productos",
                productoRepo.findAll()
        );

        model.addAttribute(
                "producto",
                new Producto()
        );

        return "admin-menu";
    }

    // GUARDAR PRODUCTO
   @PostMapping("/guardar")
    public String guardarProducto(
            @ModelAttribute Producto producto,
            @RequestParam("archivoImagen") MultipartFile archivoImagen
    ) throws IOException {

        if (!archivoImagen.isEmpty()) {

            String carpeta = "uploads/img/";

            Files.createDirectories(Paths.get(carpeta));

            String nombreArchivo = archivoImagen.getOriginalFilename();

            Path ruta = Paths.get(carpeta + nombreArchivo);

            Files.write(ruta, archivoImagen.getBytes());

            producto.setImagen("/img/" + nombreArchivo);
        }

        productoRepo.save(producto);

        return "redirect:/admin/menu";
    }

    // EDITAR PRODUCTO
    @GetMapping("/editar/{id}")
    public String editarProducto(
            @PathVariable Long id,
            Model model
    ) {

        Producto producto = productoRepo
                .findById(id)
                .orElse(null);

        model.addAttribute("producto", producto);

        model.addAttribute(
                "productos",
                productoRepo.findAll()
        );

        return "admin-menu";
    }

    // ELIMINAR PRODUCTO
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(
            @PathVariable Long id
    ) {

        productoRepo.deleteById(id);

        return "redirect:/admin/menu";
    }

}
