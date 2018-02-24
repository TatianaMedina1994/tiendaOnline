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

import com.tienda.online.model.DetalleCompra;
import com.tienda.online.model.Usuario;
import com.tienda.online.service.DetalleCompraService;

@RestController
@RequestMapping("/detalleCompra")
public class DetalleCompraController {

	DetalleCompraService detalleCompraService;
	private static final Logger logger = LoggerFactory.getLogger(Usuario.class); // logs

	public DetalleCompraController() {

	}

	@Autowired
	public DetalleCompraController(DetalleCompraService detalleCompraService) {
		super();
		this.detalleCompraService = detalleCompraService;
	}

	@PostMapping(produces = "application/json")
	public DetalleCompra guardarDetalleCompra(@RequestBody @Validated DetalleCompra detalleCompra) {
		try {
			return detalleCompraService.guardar(detalleCompra);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del detalleCompraController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@GetMapping(produces = "application/json")
	public List<DetalleCompra> obtenerTodos() {
		try {
			return detalleCompraService.obtenerTodos();
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del detalleCompraController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@PutMapping(produces = "application/json")
	public DetalleCompra actualizarCompra(@RequestBody @Validated DetalleCompra detalleCompra) {
		try {
			return detalleCompraService.guardar(detalleCompra);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del CompraController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

	@RequestMapping(path = "/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable(value = "id") Integer id) {
		try {
			detalleCompraService.eliminar(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Error en el servicio del compraController: " + e.getMessage());
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}

}
