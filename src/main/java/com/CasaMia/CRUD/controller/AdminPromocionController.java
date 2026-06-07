package com.CasaMia.CRUD.CONTROLLER;

import com.CasaMia.CRUD.MODELS.Producto;
import com.CasaMia.CRUD.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/promociones")
public class AdminPromocionController {

    @Autowired
    private ProductoRepository productoRepo;

    @GetMapping
    public String verPromociones(Model model) {
        model.addAttribute("productos", productoRepo.findAll());
        return "admin-promociones";
    }

    @PostMapping("/guardar/{id}")
    public String guardarPromocion(
            @PathVariable Long id,
            @RequestParam(required = false) boolean promocion,
            @RequestParam double precioPromocion,
            @RequestParam String textoPromocion
    ) {
        Producto producto = productoRepo.findById(id).orElse(null);

        if (producto != null) {
            producto.setPromocion(promocion);
            producto.setPrecioPromocion(precioPromocion);
            producto.setTextoPromocion(textoPromocion);
            productoRepo.save(producto);
        }

        return "redirect:/admin/promociones";
    }

    @GetMapping("/quitar/{id}")
    public String quitarPromocion(@PathVariable Long id) {
        Producto producto = productoRepo.findById(id).orElse(null);

        if (producto != null) {
            producto.setPromocion(false);
            producto.setPrecioPromocion(0);
            producto.setTextoPromocion("");
            productoRepo.save(producto);
        }

        return "redirect:/admin/promociones";
    }
}
