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

import com.tienda.online.model.Articulo;
import com.tienda.online.model.Usuario;
import com.tienda.online.service.ArticuloService;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {

	ArticuloService articuloService;
	private static final Logger logger = LoggerFactory.getLogger(Usuario.class); // logs

	public ArticuloController() {

	}

	@Autowired
	public ArticuloController(ArticuloService articuloService) {
		super();
		this.articuloService = articuloService;
	}

	@PostMapping(produces = "application/json")
	public Articulo guardarArticulo(@RequestBody @Validated Articulo articulo) {
		try {
			return articuloService.guardar(articulo);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del ArticuloController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@GetMapping(produces = "application/json")
	public List<Articulo> obtenerTodos() {
		try {
			return articuloService.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del ArticuloController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@PutMapping(produces = "application/json")
	public Articulo actualizarArticulo(@RequestBody @Validated Articulo articulo) {
		try {
			return articuloService.guardar(articulo);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del ArticuloController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@RequestMapping(path = "/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable(value = "id") Integer id) {
		try {
			articuloService.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del compraController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

}
