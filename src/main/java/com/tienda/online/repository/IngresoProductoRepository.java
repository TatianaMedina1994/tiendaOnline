package com.tienda.online.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.model.IngresoProducto;

@Repository
public interface IngresoProductoRepository extends CrudRepository<IngresoProducto, Integer>{

}
