package com.CasaMia.CRUD.MODELS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CasaMia.CRUD.MODELS.Reserva;
import com.CasaMia.CRUD.repository.ReservaRepository;

/**
 * Servicio encargado de gestionar las operaciones
 * relacionadas con las reservas del sistema CasaMia.
 *
 * Esta clase permite almacenar información
 * de las reservas realizadas por los clientes.
 *
 * Utiliza el repositorio ReservaRepository
 * para acceder y persistir datos en la base de datos.
 *
 * @author Flore
 * @version 1.0
 */

@Service
public class ReservaService {

    /**
     * Repositorio utilizado para gestionar
     * las operaciones de reservas.
     */
    @Autowired
    private ReservaRepository repo;

    /**
     * Guarda una reserva en la base de datos.
     *
     * Este método permite registrar una nueva
     * reserva o actualizar una existente.
     *
     * @param r Reserva que será almacenada.
     */
    public void save(Reserva r) {
        repo.save(r);
    }
}