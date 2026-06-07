/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.exepcion;

public class PedidoNoEncontradoException extends RuntimeException {

    public PedidoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}