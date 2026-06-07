/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CasaMia.CRUD.repository;

import com.CasaMia.CRUD.MODELS.Reserva;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    boolean existsByMesaAndFechaAndHoraAndEstado(
        Integer mesa,
        LocalDate fecha,
        LocalTime hora,
        String estado
    );

    List<Reserva> findByFechaAndHora(
            LocalDate fecha,
            LocalTime hora
    );
    
    List<Reserva> findByMesaAndFechaAndEstado(
        Integer mesa,
        LocalDate fecha,
        String estado
);
}
