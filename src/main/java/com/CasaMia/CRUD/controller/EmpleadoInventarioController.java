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

@Controller
@RequestMapping("/empleado/inventario")
public class EmpleadoInventarioController {

    @Autowired
    private ProductoRepository productoRepo;

    @GetMapping
    public String inventario(Model model) {
        model.addAttribute("productos", productoRepo.findAll());
        return "empleado-inventario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarStock(
            @PathVariable Long id,
            @RequestParam Integer cantidad
    ) {
        Producto producto = productoRepo.findById(id).orElse(null);

        if (producto != null) {
            producto.setCantidad(cantidad);
            productoRepo.save(producto);
        }

        return "redirect:/empleado/inventario";
    }
}
