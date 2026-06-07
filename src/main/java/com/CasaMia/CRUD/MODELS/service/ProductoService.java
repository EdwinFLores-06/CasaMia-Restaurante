package com.CasaMia.CRUD.MODELS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CasaMia.CRUD.MODELS.Producto;
import com.CasaMia.CRUD.repository.ProductoRepository;

/**
 * Servicio encargado de gestionar las operaciones
 * relacionadas con los productos del sistema CasaMia.
 *
 * Esta clase permite consultar la información
 * de los productos almacenados en la base de datos.
 *
 * Utiliza el repositorio ProductoRepository
 * para acceder a los datos.
 *
 * @author Flore
 * @version 1.0
 */

@Service
public class ProductoService {

    /**
     * Repositorio utilizado para acceder
     * a la información de los productos.
     */
    @Autowired
    private ProductoRepository repo;

    /**
     * Obtiene la lista completa de productos.
     *
     * @return Lista de productos registrados.
     */
    public List<Producto> findAll() {
        return repo.findAll();
    }

    /**
     * Busca un producto utilizando su identificador.
     *
     * @param id ID del producto.
     * @return Producto encontrado o null
     * si no existe.
     */
    public Producto findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}