package com.tienda.online.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.model.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, String>{

}
