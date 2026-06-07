/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

import com.CasaMia.CRUD.MODELS.Producto;
import com.CasaMia.CRUD.MODELS.Promocion;
import com.CasaMia.CRUD.repository.ProductoRepository;
import com.CasaMia.CRUD.repository.PromocionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientePromocionesController {

    @Autowired
    private ProductoRepository productoRepo;

    @Autowired
    private PromocionRepository promocionRepo;

    @GetMapping("/promociones")
    public String promociones(Model model) {

        List<Producto> promociones = productoRepo.findAll()
                .stream()
                .filter(p -> p.isPromocion())
                .toList();

        List<Promocion> combos = promocionRepo.findByActivaTrue();

        model.addAttribute("promociones", promociones);
        model.addAttribute("combos", combos);

        return "promociones";
    }
}
