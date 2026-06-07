/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

import com.CasaMia.CRUD.MODELS.Producto;
import com.CasaMia.CRUD.repository.ProductoRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/empleado/menu")
public class EmpleadoMenuController {

    @Autowired
    private ProductoRepository productoRepo;

    @GetMapping
    public String mostrarMenu(Model model) {

        model.addAttribute("productos", productoRepo.findAll());
        model.addAttribute("producto", new Producto());

        return "empleado-menu";
    }

    @PostMapping("/guardar")
    public String guardarProducto(
            @ModelAttribute Producto producto,
            @RequestParam("archivoImagen") MultipartFile archivoImagen
    ) throws IOException {

        Producto productoExistente = null;

        if (producto.getIdProducto() != null) {
            productoExistente = productoRepo
                    .findById(producto.getIdProducto())
                    .orElse(null);
        }

        if (productoExistente != null) {

            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setCategoria(producto.getCategoria());

            if (!archivoImagen.isEmpty()) {

                String carpeta = "uploads/img/";
                Files.createDirectories(Paths.get(carpeta));

                String nombreArchivo = archivoImagen.getOriginalFilename();

                Path ruta = Paths.get(carpeta + nombreArchivo);
                Files.write(ruta, archivoImagen.getBytes());

                productoExistente.setImagen("/img/" + nombreArchivo);
            }

            productoRepo.save(productoExistente);

        } else {

            producto.setCantidad(0);

            if (!archivoImagen.isEmpty()) {

                String carpeta = "uploads/img/";
                Files.createDirectories(Paths.get(carpeta));

                String nombreArchivo = archivoImagen.getOriginalFilename();

                Path ruta = Paths.get(carpeta + nombreArchivo);
                Files.write(ruta, archivoImagen.getBytes());

                producto.setImagen("/img/" + nombreArchivo);
            }

            productoRepo.save(producto);
        }

        return "redirect:/empleado/menu";
    }

    @GetMapping("/editar/{id}")
    public String editarProducto(
            @PathVariable Long id,
            Model model
    ) {

        Producto producto = productoRepo
                .findById(id)
                .orElse(new Producto());

        model.addAttribute("producto", producto);
        model.addAttribute("productos", productoRepo.findAll());

        return "empleado-menu";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {

        productoRepo.deleteById(id);

        return "redirect:/empleado/menu";
    }
}