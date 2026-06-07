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
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminInventarioReporteController {

    @Autowired
    private ProductoRepository productoRepo;

    @GetMapping("/admin/reporte-inventario")
    public String reporteInventario(Model model) {

        List<Producto> productos = productoRepo.findAll();

        long totalProductos = productos.size();

        long stockBajo = productos.stream()
                .filter(p -> p.getCantidad() != null && p.getCantidad() <= 5)
                .count();

        int unidadesTotales = productos.stream()
                .filter(p -> p.getCantidad() != null)
                .mapToInt(Producto::getCantidad)
                .sum();

        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", totalProductos);
        model.addAttribute("stockBajo", stockBajo);
        model.addAttribute("unidadesTotales", unidadesTotales);

        return "admin-reporte-inventario";
    }
}
