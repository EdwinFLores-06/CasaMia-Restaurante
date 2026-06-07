/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CasaMia.CRUD.repository;

import com.CasaMia.CRUD.MODELS.Promocion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocionRepository extends JpaRepository<Promocion, Long> {

    List<Promocion> findByActivaTrue();
}
