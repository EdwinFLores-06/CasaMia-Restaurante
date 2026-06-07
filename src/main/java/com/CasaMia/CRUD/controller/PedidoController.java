/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

import com.CasaMia.CRUD.MODELS.Item;
import com.CasaMia.CRUD.MODELS.Producto;
import com.CasaMia.CRUD.MODELS.Orden;
import com.CasaMia.CRUD.MODELS.DetalleOrden;

import com.CasaMia.CRUD.repository.ProductoRepository;
import com.CasaMia.CRUD.repository.OrdenRepository;

import com.CasaMia.CRUD.MODELS.Promocion;
import com.CasaMia.CRUD.repository.PromocionRepository;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PedidoController {

    @Autowired
    private ProductoRepository productoRepo;

    @Autowired
    private OrdenRepository ordenRepo;
    
    @Autowired
    private PromocionRepository promocionRepo;

    @GetMapping("/carrito")
    public String verCarrito(
            HttpSession session,
            Model model
    ) {

        List<Item> carrito =
                (List<Item>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
        }

        double total = carrito.stream()
                .mapToDouble(Item::getSubtotal)
                .sum();

        model.addAttribute("carrito", carrito);
        model.addAttribute("total", total);

        return "carrito";
    }

    @PostMapping("/carrito/agregar/{id}")
    public String agregarAlCarrito(
            @PathVariable Long id,
            @RequestParam int cantidad,
            HttpSession session
    ) {

        List<Item> carrito =
                (List<Item>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
        }

        Producto producto = productoRepo
                .findById(id)
                .orElse(null);

        if (producto == null) {
            return "redirect:/menu";
        }

        if (cantidad < 1) {
            cantidad = 1;
        }

        if (producto.getCantidad() != null
                && cantidad > producto.getCantidad()) {

            cantidad = producto.getCantidad();
        }

        double precioFinal;

        if (producto.isPromocion()
                && producto.getPrecioPromocion() > 0) {

            precioFinal = producto.getPrecioPromocion();

        } else {

            precioFinal = producto.getPrecio();
        }

        boolean existe = false;

        for (Item item : carrito) {

            if (item.getIdProducto().equals(id)) {

                item.setCantidad(
                        item.getCantidad() + cantidad
                );

                existe = true;
                break;
            }
        }

        if (!existe) {

            Item item = new Item(
                    producto.getIdProducto(),
                    producto.getNombre(),
                    precioFinal,
                    cantidad
            );

            carrito.add(item);
        }

        session.setAttribute("carrito", carrito);

        return "redirect:/carrito";
    }

    @GetMapping("/pedido")
    public String verPedido(
            HttpSession session,
            Model model
    ) {

        List<Item> carrito =
                (List<Item>) session.getAttribute("carrito");

        if (carrito == null || carrito.isEmpty()) {
            return "redirect:/menu";
        }

        double total = carrito.stream()
                .mapToDouble(Item::getSubtotal)
                .sum();

        model.addAttribute("carrito", carrito);
        model.addAttribute("total", total);

        return "pedido";
    }
    
    @PostMapping("/carrito/agregar-combo/{id}")
    public String agregarComboAlCarrito(
            @PathVariable Long id,
            @RequestParam int cantidad,
            HttpSession session
    ) {

        List<Item> carrito =
                (List<Item>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
        }

        Promocion combo = promocionRepo
                .findById(id)
                .orElse(null);

        if (combo == null || !combo.isActiva()) {
            return "redirect:/home";
        }

        if (cantidad < 1) {
            cantidad = 1;
        }

        Item item = new Item(
                -id,
                "COMBO: " + combo.getNombre(),
                combo.getPrecioCombo(),
                cantidad
        );

        carrito.add(item);

        session.setAttribute("carrito", carrito);

        return "redirect:/carrito";
    }

    @PostMapping("/confirmar-pedido")
    public String confirmarPedido(
            @RequestParam String direccion,
            @RequestParam String telefono,
            @RequestParam String pago,
            @RequestParam String comentario,
            @RequestParam(required = false) String nombreTarjeta,
            @RequestParam(required = false) String numeroTarjeta,
            @RequestParam(required = false) String vencimiento,
            @RequestParam(required = false) String cvv,
            HttpSession session,
            Model model,
            java.security.Principal principal
    ) {

        List<Item> carrito =
                (List<Item>) session.getAttribute("carrito");

        if (carrito == null || carrito.isEmpty()) {
            return "redirect:/menu";
        }

        if (direccion.trim().isEmpty()
                || telefono.trim().isEmpty()
                || pago.trim().isEmpty()
                || comentario.trim().isEmpty()) {
            return "redirect:/pedido?datosIncompletos";
        }

        if (!telefono.matches("\\d{8}")) {
            return "redirect:/pedido?telefonoInvalido";
        }

        if (!pago.equals("Efectivo") && !pago.equals("Tarjeta")) {
            return "redirect:/pedido?pagoInvalido";
        }

        if (pago.equals("Tarjeta")) {
            if (nombreTarjeta == null || nombreTarjeta.trim().isEmpty()
                    || numeroTarjeta == null || !numeroTarjeta.matches("\\d{4} \\d{4} \\d{4} \\d{4}")
                    || vencimiento == null || !vencimiento.matches("\\d{2}/\\d{2}")
                    || cvv == null || !cvv.matches("\\d{3}")) {
                return "redirect:/pedido?tarjetaInvalida";
            }
        }

        double total = carrito.stream()
                .mapToDouble(Item::getSubtotal)
                .sum();

        Orden orden = new Orden();

        orden.setFecha(java.time.LocalDateTime.now());
        orden.setEstado("PENDIENTE");
        orden.setTotal(total);

        orden.setClienteUsername(principal.getName());
        orden.setDireccion(direccion);
        orden.setTelefono(telefono);
        orden.setPago(pago);
        orden.setComentario(comentario);

        for (Item item : carrito) {
            DetalleOrden detalle = new DetalleOrden();

            detalle.setNombreProducto(
                    item.getNombre() + " x" + item.getCantidad()
            );

            detalle.setPrecio(item.getSubtotal());
            detalle.setOrden(orden);

            orden.getDetalles().add(detalle);
        }

        ordenRepo.save(orden);

        String tarjetaMostrada = null;

        if (pago.equals("Tarjeta") && numeroTarjeta != null) {
            String limpia = numeroTarjeta.replace(" ", "");

            if (limpia.length() >= 16) {
                tarjetaMostrada =
                        limpia.substring(0, 8)
                        + "XXXXXXXX";
            }
        }

        model.addAttribute("direccion", direccion);
        model.addAttribute("telefono", telefono);
        model.addAttribute("pago", pago);
        model.addAttribute("comentario", comentario);
        model.addAttribute("carrito", carrito);
        model.addAttribute("total", total);
        model.addAttribute("nombreTarjeta", nombreTarjeta);
        model.addAttribute("tarjetaMostrada", tarjetaMostrada);
        model.addAttribute("fechaFactura", java.time.LocalDateTime.now());

        session.removeAttribute("carrito");

        return "confirmacion";
    }
}