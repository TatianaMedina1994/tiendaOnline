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

import com.tienda.online.model.IngresoProducto;
import com.tienda.online.model.Usuario;
import com.tienda.online.service.IngresoProductoService;

@RestController
@RequestMapping("/ingresoProducto")
public class IngresoProductoController {

	IngresoProductoService ingresoProductoService;
	private static final Logger logger = LoggerFactory.getLogger(Usuario.class); // logs

	public IngresoProductoController() {

	}

	@Autowired
	public IngresoProductoController(IngresoProductoService ingresoProductoService) {
		super();
		this.ingresoProductoService = ingresoProductoService;
	}

	@PostMapping(produces = "application/json")
	public IngresoProducto guardarIngresoProducto(@RequestBody @Validated IngresoProducto ingresoProducto) {
		try {
			return ingresoProductoService.guardar(ingresoProducto);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del IngresoProductoController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@GetMapping(produces = "application/json")
	public List<IngresoProducto> obtenerTodos() {
		try {
			return ingresoProductoService.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del IngresoProductoController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@PutMapping(produces = "application/json")
	public IngresoProducto actualizarProducto(@RequestBody @Validated IngresoProducto ingresoProducto) {
		try {
			return ingresoProductoService.guardar(ingresoProducto);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del IngresoProductoController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@RequestMapping(path = "/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable(value = "id") Integer id) {
		try {
			ingresoProductoService.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del compraController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

}
