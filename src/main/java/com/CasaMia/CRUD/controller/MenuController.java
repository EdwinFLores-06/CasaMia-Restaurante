/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

import com.CasaMia.CRUD.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @Autowired
    private ProductoRepository productoRepo;

    @GetMapping("/menu")
    public String menu(Model model) {

        model.addAttribute(
                "productos",
                productoRepo.findAll()
        );

        return "menu";
    }
}
