/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.exepcion;

/**
 *
 * @author fabri
 */

public class UsuarioDuplicadoException extends RuntimeException {

    public UsuarioDuplicadoException(String mensaje) {
        super(mensaje);
    }
}