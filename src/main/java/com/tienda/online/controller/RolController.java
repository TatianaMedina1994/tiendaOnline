package com.tienda.online.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.online.model.Rol;
import com.tienda.online.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {

	RolService rolService;
	private static final Logger logger = LoggerFactory.getLogger(Rol.class); // logs

	public RolController() {

	}

	@Autowired
	public RolController(RolService rolService) {
		super();
		this.rolService = rolService;
	}

	@PostMapping(produces = "application/json")
	public Rol guardarRol(@RequestBody @Validated Rol rol) {
		try {
			return rolService.guardar(rol);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del RolController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@GetMapping(produces = "application/json")
	public List<Rol> obtenerTodos() {
		try {
			return rolService.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del RolController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@PutMapping(produces = "application/json")
	public Rol atualizarRol(@RequestBody @Validated Rol rol) {
		try {
			return rolService.guardar(rol);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del rolController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@RequestMapping(path = "/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable(value = "id") Integer id) {
		try {
			rolService.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del rolController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

}
