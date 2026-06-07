/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CasaMia.CRUD.repository;

import com.CasaMia.CRUD.MODELS.Orden;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
    
    List<Orden> findByClienteUsernameOrderByFechaDesc(String clienteUsername);
}
