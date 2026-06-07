/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

import com.CasaMia.CRUD.MODELS.Reserva;
import com.CasaMia.CRUD.repository.ReservaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepo;

    @GetMapping("/reservas")
    public String reservas() {
        return "reservas";
    }

    @PostMapping("/reservar")
    public String reservar(
            @RequestParam String nombre,
            @RequestParam LocalDate fecha,
            @RequestParam LocalTime hora,
            @RequestParam Integer personas,
            @RequestParam Integer mesa
    ) {

        boolean ocupada = reservaRepo
                .findByMesaAndFechaAndEstado(mesa, fecha, "PENDIENTE")
                .stream()
                .anyMatch(r -> {
                    LocalTime inicioBloqueo = r.getHora().minusMinutes(30);
                    LocalTime finBloqueo = r.getHora().plusMinutes(60);

                    return !hora.isBefore(inicioBloqueo)
                            && !hora.isAfter(finBloqueo);
                });

        if (ocupada) {
            return "redirect:/reservas?ocupada";
        }

        Reserva reserva = new Reserva();
        reserva.setNombre(nombre);
        reserva.setFecha(fecha);
        reserva.setHora(hora);
        reserva.setPersonas(personas);
        reserva.setMesa(mesa);
        reserva.setEstado("PENDIENTE");

        reservaRepo.save(reserva);

        return "redirect:/reservas?ok";
    }

    @GetMapping("/reservas/ocupadas")
    @ResponseBody
    public List<Integer> mesasOcupadas(
            @RequestParam LocalDate fecha,
            @RequestParam LocalTime hora
    ) {
        return reservaRepo.findAll()
                .stream()
                .filter(r -> r.getEstado().equals("PENDIENTE"))
                .filter(r -> r.getFecha().equals(fecha))
                .filter(r -> {
                    LocalTime inicioBloqueo = r.getHora().minusMinutes(30);
                    LocalTime finBloqueo = r.getHora().plusMinutes(80);

                    return !hora.isBefore(inicioBloqueo)
                            && !hora.isAfter(finBloqueo);
                })
                .map(Reserva::getMesa)
                .distinct()
                .toList();
    }
}
