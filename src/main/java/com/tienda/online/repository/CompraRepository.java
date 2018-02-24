package com.tienda.online.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.model.Compra;

@Repository
public interface CompraRepository  extends CrudRepository<Compra, Integer>{

}
