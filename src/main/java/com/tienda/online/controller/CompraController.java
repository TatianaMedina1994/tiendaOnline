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

import com.tienda.online.model.Compra;
import com.tienda.online.model.Usuario;
import com.tienda.online.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

	CompraService compraService;
	private static final Logger logger = LoggerFactory.getLogger(Usuario.class); // logs

	public CompraController() {

	}

	@Autowired
	public CompraController(CompraService compraService) {
		super();
		this.compraService = compraService;
	}

	@PostMapping(produces = "application/json")
	public Compra guardarCompra(@RequestBody @Validated Compra compra) {
		try {
			return compraService.guardar(compra);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del CompraController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@GetMapping(produces = "application/json")
	public List<Compra> obtenerTodos() {
		try {
			return compraService.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del CompraController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@PutMapping(produces = "application/json")
	public Compra actualizarCompra(@RequestBody @Validated Compra compra) {
		try {
			return compraService.guardar(compra);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del CompraController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@RequestMapping(path = "/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable(value = "id") Integer id) {
		try {
			compraService.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del compraController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

}
