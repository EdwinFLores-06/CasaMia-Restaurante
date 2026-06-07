/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

/**
 *
 * @author fabri
 */
import com.CasaMia.CRUD.repository.ProductoRepository;
import com.CasaMia.CRUD.repository.PromocionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProductoRepository productoRepo;

    @Autowired
    private PromocionRepository promocionRepo;

    @GetMapping("/home")
    public String home(Model model) {

        model.addAttribute(
                "productos",
                productoRepo.findAll());

        model.addAttribute(
                "promociones",
                promocionRepo.findAll());

        return "home";
    }
}