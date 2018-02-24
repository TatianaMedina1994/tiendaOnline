package com.tienda.online.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.online.model.Usuario;

@Repository
public interface UsuarioRepository  extends CrudRepository<Usuario, Integer> {

Usuario findByEmail (String correo);

}
