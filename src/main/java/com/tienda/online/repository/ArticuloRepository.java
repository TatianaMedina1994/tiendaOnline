package com.tienda.online.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.model.Articulo;

@Repository
public interface ArticuloRepository extends CrudRepository<Articulo, Integer> {

	
}
