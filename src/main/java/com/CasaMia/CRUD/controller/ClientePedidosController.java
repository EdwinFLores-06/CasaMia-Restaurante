/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

import com.CasaMia.CRUD.repository.OrdenRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientePedidosController {

    @Autowired
    private OrdenRepository ordenRepo;

    @GetMapping("/mis-pedidos")
    public String misPedidos(Model model, Principal principal) {

        model.addAttribute(
                "ordenes",
                ordenRepo.findByClienteUsernameOrderByFechaDesc(
                        principal.getName()
                )
        );

        return "mis-pedidos";
    }
}
