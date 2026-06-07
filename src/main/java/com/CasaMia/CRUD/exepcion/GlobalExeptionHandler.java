/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.exepcion;

/**
 *
 * @author fabri
 */
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExeptionHandler {
    // =====================================================
    // PEDIDO NO ENCONTRADO
    // =====================================================

    @ExceptionHandler(PedidoNoEncontradoException.class)
    public String manejarPedidoNoEncontrado(
            PedidoNoEncontradoException ex,
            Model model) {

        model.addAttribute("titulo", "Pedido no encontrado");
        model.addAttribute("error", ex.getMessage());

        return "error";
    }

    // =====================================================
    // USUARIO DUPLICADO
    // =====================================================

    @ExceptionHandler(UsuarioDuplicadoException.class)
    public String manejarUsuarioDuplicado(
            UsuarioDuplicadoException ex,
            Model model) {

        model.addAttribute("titulo", "Usuario duplicado");
        model.addAttribute("error", ex.getMessage());

        return "error";
    }

    // =====================================================
    // STOCK INSUFICIENTE
    // =====================================================

    @ExceptionHandler(StockInsuficienteException.class)
    public String manejarStock(
            StockInsuficienteException ex,
            Model model) {

        model.addAttribute("titulo", "Stock insuficiente");
        model.addAttribute("error", ex.getMessage());

        return "error";
    }

    // =====================================================
    // RESERVA INVÁLIDA
    // =====================================================

    @ExceptionHandler(ReservaInvalidaException.class)
    public String manejarReserva(
            ReservaInvalidaException ex,
            Model model) {

        model.addAttribute("titulo", "Reserva inválida");
        model.addAttribute("error", ex.getMessage());

        return "error";
    }

    // =====================================================
    // ERROR DE BASE DE DATOS
    // =====================================================

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String manejarBaseDatos(
            DataIntegrityViolationException ex,
            Model model) {

        model.addAttribute("titulo", "Error de base de datos");

        model.addAttribute("error",
                "Ocurrió un problema al guardar los datos");

        return "error";
    }

    // =====================================================
    // ERROR GENERAL
    // =====================================================

    @ExceptionHandler(Exception.class)
    public String manejarErrorGeneral(
            Exception ex,
            Model model) {

        model.addAttribute("titulo", "Error inesperado");

        model.addAttribute("error",
                "Ocurrió un error inesperado en el sistema");

        model.addAttribute("detalle",
                ex.getMessage());

        return "error";
    }
}

