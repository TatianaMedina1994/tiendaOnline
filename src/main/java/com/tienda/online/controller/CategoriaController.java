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

import com.tienda.online.model.Categoria;
import com.tienda.online.model.Rol;
import com.tienda.online.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	private CategoriaService categoriaService;
	private static final Logger logger = LoggerFactory.getLogger(Rol.class); // logs

	public CategoriaController() {

	}

	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		super();
		this.categoriaService = categoriaService;
	}

	@PostMapping(produces = "application/json")
	public Categoria guardarCategoria(@RequestBody @Validated Categoria categoria) {
		try {
			return categoriaService.guardar(categoria);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del categoriaController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@GetMapping(produces = "application/json")
	public List<Categoria> obtenerTodos() {
		try {
			return categoriaService.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del categoriaController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@PutMapping(produces = "application/json")
	public Categoria atualizarCategoria(@RequestBody @Validated Categoria categoria) {
		try {
			return categoriaService.guardar(categoria);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del categoriaController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@RequestMapping(path = "/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable(value = "id") String id) {
		try {
			categoriaService.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del rolController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

}
