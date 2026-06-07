/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

import com.CasaMia.CRUD.MODELS.Orden;
import com.CasaMia.CRUD.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminOrdenesController {

    @Autowired
    private OrdenRepository ordenRepo;

    @GetMapping("/admin/ordenes")
    public String verOrdenes(Model model) {
        model.addAttribute("ordenes", ordenRepo.findAll());
        return "admin-ordenes";
    }

    @GetMapping("/admin/ordenes/completar/{id}")
    public String completarOrden(@PathVariable Long id) {
        Orden orden = ordenRepo.findById(id).orElse(null);

        if (orden != null) {
            orden.setEstado("COMPLETADA");
            ordenRepo.save(orden);
        }

        return "redirect:/admin/ordenes";
    }
}
