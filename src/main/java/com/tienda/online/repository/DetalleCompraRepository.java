package com.tienda.online.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.model.DetalleCompra;

@Repository
public interface DetalleCompraRepository extends CrudRepository<DetalleCompra, Integer>{

}
