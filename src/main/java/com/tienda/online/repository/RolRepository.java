package com.tienda.online.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.model.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {
	

	

}
