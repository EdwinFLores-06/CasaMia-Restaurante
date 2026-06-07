/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

import com.CasaMia.CRUD.MODELS.DetalleOrden;
import com.CasaMia.CRUD.MODELS.Item;
import com.CasaMia.CRUD.MODELS.Orden;
import com.CasaMia.CRUD.MODELS.Producto;

import com.CasaMia.CRUD.repository.OrdenRepository;
import com.CasaMia.CRUD.repository.ProductoRepository;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdenController {

    @Autowired
    private OrdenRepository ordenRepo;

    @Autowired
    private ProductoRepository productoRepo;

    @GetMapping("/orden/realizar")
    public String realizarOrden(HttpSession session) {

        List<Item> carrito =
                (List<Item>) session.getAttribute("carrito");

        if (carrito == null || carrito.isEmpty()) {
            return "redirect:/carrito";
        }

        for (Item item : carrito) {

            Producto productoBD = productoRepo
                    .findById(item.getIdProducto())
                    .orElse(null);

            if (productoBD == null
                    || productoBD.getCantidad() == null
                    || productoBD.getCantidad() < item.getCantidad()) {

                return "redirect:/carrito?sinStock";
            }
        }

        Orden orden = new Orden();

        orden.setFecha(LocalDateTime.now());
        orden.setEstado("PENDIENTE");

        double total = 0;

        for (Item item : carrito) {

            Producto productoBD = productoRepo
                    .findById(item.getIdProducto())
                    .orElse(null);

            if (productoBD != null) {

                productoBD.setCantidad(
                        productoBD.getCantidad() - item.getCantidad()
                );

                productoRepo.save(productoBD);

                DetalleOrden detalle = new DetalleOrden();

                detalle.setNombreProducto(
                        productoBD.getNombre()
                        + " x" + item.getCantidad()
                );

                detalle.setPrecio(
                        item.getSubtotal()
                );

                detalle.setOrden(orden);

                orden.getDetalles().add(detalle);

                total += item.getSubtotal();
            }
        }

        orden.setTotal(total);

        ordenRepo.save(orden);

        session.removeAttribute("carrito");

        return "redirect:/carrito?orden=true";
    }
}
