/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

import com.CasaMia.CRUD.MODELS.Reserva;
import com.CasaMia.CRUD.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empleado/reservas")
public class EmpleadoReservasController {

    @Autowired
    private ReservaRepository reservaRepo;

    @GetMapping
    public String verReservas(Model model) {

        model.addAttribute("reservas", reservaRepo.findAll());

        return "empleado-reservas";
    }

    @GetMapping("/cancelar/{id}")
    public String cancelarReserva(@PathVariable Long id) {

        Reserva reserva = reservaRepo.findById(id).orElse(null);

        if (reserva != null) {
            reserva.setEstado("CANCELADA");
            reservaRepo.save(reserva);
        }

        return "redirect:/empleado/reservas?cancelada";
    }
}