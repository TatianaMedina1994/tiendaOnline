package com.tienda.online.service;

import java.util.Date;
import java.util.List;

import org.junit.runners.Parameterized.UseParametersRunnerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.model.Usuario;
import com.tienda.online.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService() {

	}
     @Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario guardar(Usuario usuario) {
		usuario.setFecha(new Date());
		Usuario nuevo=usuarioRepository.findByEmail(usuario.getEmail());
		if (nuevo==null) {
			return usuarioRepository.save(usuario);	
		}
		else {
			return null;
		}
		
	}

	public List<Usuario> obtenerTodos() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	public long total() {
		return usuarioRepository.count();
	}

	public void eliminar(Integer id) {
		usuarioRepository.delete(id);
	}

}
