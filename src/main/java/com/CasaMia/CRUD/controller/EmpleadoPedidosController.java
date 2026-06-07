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
@RequestMapping("/empleado/pedidos")
public class EmpleadoPedidosController {

    @Autowired
    private OrdenRepository ordenRepo;

    @GetMapping
    public String verPedidos(Model model) {
        model.addAttribute("ordenes", ordenRepo.findAll());
        return "empleado-pedidos";
    }

    @GetMapping("/entregado/{id}")
    public String marcarEntregado(@PathVariable Long id) {
        Orden orden = ordenRepo.findById(id).orElse(null);

        if (orden != null) {
            orden.setEstado("ENTREGADO");
            ordenRepo.save(orden);
        }

        return "redirect:/empleado/pedidos";
    }

    @GetMapping("/pendiente/{id}")
    public String marcarPendiente(@PathVariable Long id) {
        Orden orden = ordenRepo.findById(id).orElse(null);

        if (orden != null) {
            orden.setEstado("PENDIENTE");
            ordenRepo.save(orden);
        }

        return "redirect:/empleado/pedidos";
    }
}
