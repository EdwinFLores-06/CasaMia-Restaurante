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
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/combos")
public class AdminCombosController {

    @Autowired
    private PromocionRepository promocionRepo;

    @Autowired
    private ProductoRepository productoRepo;

    @GetMapping
    public String verCombos(Model model) {
        model.addAttribute("combos", promocionRepo.findAll());
        model.addAttribute("productos", productoRepo.findAll());
        return "admin-combos";
    }

    @PostMapping("/guardar")
    public String guardarCombo(
            @RequestParam String nombre,
            @RequestParam String descripcion,
            @RequestParam double precioCombo,
            @RequestParam(required = false) boolean activa,
            @RequestParam List<Long> productosIds
    ) {

        List<Producto> productos = productoRepo.findAllById(productosIds);

        Promocion promo = new Promocion();
        promo.setNombre(nombre);
        promo.setDescripcion(descripcion);
        promo.setPrecioCombo(precioCombo);
        promo.setActiva(activa);
        promo.setProductos(productos);

        promocionRepo.save(promo);

        return "redirect:/admin/combos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCombo(@PathVariable Long id) {
        promocionRepo.deleteById(id);
        return "redirect:/admin/combos";
    }

    @GetMapping("/activar/{id}")
    public String activarCombo(@PathVariable Long id) {
        Promocion promo = promocionRepo.findById(id).orElse(null);

        if (promo != null) {
            promo.setActiva(true);
            promocionRepo.save(promo);
        }

        return "redirect:/admin/combos";
    }

    @GetMapping("/desactivar/{id}")
    public String desactivarCombo(@PathVariable Long id) {
        Promocion promo = promocionRepo.findById(id).orElse(null);

        if (promo != null) {
            promo.setActiva(false);
            promocionRepo.save(promo);
        }

        return "redirect:/admin/combos";
    }
}
