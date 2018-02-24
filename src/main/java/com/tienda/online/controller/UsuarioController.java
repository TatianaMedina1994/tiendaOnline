package com.tienda.online.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.transform.sax.TransformerHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tienda.online.model.Usuario;
import com.tienda.online.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends BaseController{

	UsuarioService usuarioService;
	private static final Logger logger = LoggerFactory.getLogger(Usuario.class); // logs

	public UsuarioController() {

	}

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	@PostMapping(produces = "application/json")
	public Usuario guardarUsuario(@RequestBody @Validated Usuario usuario) {
		try {
			Usuario nuevo=usuarioService.guardar(usuario);
			if (nuevo==null) {
				throw new DataIntegrityViolationException("Ya existe ese usuario con ese email: "+usuario.getEmail());
			}
			return usuarioService.guardar(usuario);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del UsuarioController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@GetMapping(produces = "application/json")
	public List<Usuario> obtenerTodos() {
		try {
			return usuarioService.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del UsuarioController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@PutMapping(produces = "application/json")
	public Usuario actualizarUsuario(@RequestBody @Validated Usuario usuario) {
		try {
			return usuarioService.guardar(usuario);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del UsuarioController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@RequestMapping(path = "/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable(value = "id") Integer id) {
		try {
			usuarioService.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del usuarioController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	

}
