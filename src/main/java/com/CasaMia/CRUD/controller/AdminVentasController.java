/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.controller;

import com.CasaMia.CRUD.MODELS.DetalleOrden;
import com.CasaMia.CRUD.MODELS.Orden;
import com.CasaMia.CRUD.repository.OrdenRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminVentasController {

    @Autowired
    private OrdenRepository ordenRepo;

    @GetMapping("/admin/ventas")
    public String ventas(Model model) {

        List<Orden> ordenes = ordenRepo.findAll();

        LocalDate hoy = LocalDate.now();

        double ventasTotales = ordenes.stream()
                .mapToDouble(Orden::getTotal)
                .sum();

        long pedidosRealizados = ordenes.size();

        double gananciasHoy = ordenes.stream()
                .filter(o -> o.getFecha() != null)
                .filter(o -> o.getFecha().toLocalDate().equals(hoy))
                .mapToDouble(Orden::getTotal)
                .sum();

        long pedidosHoy = ordenes.stream()
                .filter(o -> o.getFecha() != null)
                .filter(o -> o.getFecha().toLocalDate().equals(hoy))
                .count();

        Map<String, ProductoVendidoDTO> mapa = new LinkedHashMap<>();

        for (Orden orden : ordenes) {

            for (DetalleOrden detalle : orden.getDetalles()) {

                String nombre = detalle.getNombreProducto();

                mapa.putIfAbsent(
                        nombre,
                        new ProductoVendidoDTO(nombre, 0, 0)
                );

                ProductoVendidoDTO dto = mapa.get(nombre);

                dto.setCantidad(dto.getCantidad() + 1);

                dto.setGanancia(
                        dto.getGanancia() + detalle.getPrecio()
                );
            }
        }

        ProductoVendidoDTO productoMasComprado = mapa.values()
                .stream()
                .max(Comparator.comparingInt(ProductoVendidoDTO::getCantidad))
                .orElse(null);

        model.addAttribute("ventasTotales", ventasTotales);
        model.addAttribute("pedidosRealizados", pedidosRealizados);
        model.addAttribute("gananciasHoy", gananciasHoy);
        model.addAttribute("pedidosHoy", pedidosHoy);
        model.addAttribute("ordenes", ordenes);
        model.addAttribute("productosVendidos", mapa.values());
        model.addAttribute("productoMasComprado", productoMasComprado);

        return "admin-ventas";
    }

    public static class ProductoVendidoDTO {

        private String nombre;
        private int cantidad;
        private double ganancia;

        public ProductoVendidoDTO(
                String nombre,
                int cantidad,
                double ganancia
        ) {
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.ganancia = ganancia;
        }

        public String getNombre() {
            return nombre;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public double getGanancia() {
            return ganancia;
        }

        public void setGanancia(double ganancia) {
            this.ganancia = ganancia;
        }
    }
}
