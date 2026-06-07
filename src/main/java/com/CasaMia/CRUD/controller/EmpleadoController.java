/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

import com.CasaMia.CRUD.repository.OrdenRepository;
import com.CasaMia.CRUD.repository.ProductoRepository;
import com.CasaMia.CRUD.repository.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpleadoController {

    @Autowired
    private OrdenRepository ordenRepo;

    @Autowired
    private ReservaRepository reservaRepo;

    @Autowired
    private ProductoRepository productoRepo;

    @GetMapping("/empleado")
    public String empleado(Model model) {

        // CONTADORES

        long totalOrdenes = ordenRepo.count();

        long totalReservas = reservaRepo.count();

        long totalProductos = productoRepo.count();

        // ENVIAR DATOS AL HTML

        model.addAttribute("totalOrdenes", totalOrdenes);

        model.addAttribute("totalReservas", totalReservas);

        model.addAttribute("totalProductos", totalProductos);

        return "empleado";
    }
}