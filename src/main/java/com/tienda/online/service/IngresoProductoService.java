package com.tienda.online.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tienda.online.model.IngresoProducto;
import com.tienda.online.repository.IngresoProductoRepository;

@Service
public class IngresoProductoService {

	private IngresoProductoRepository ingresoProductoRepository;

	public IngresoProductoService() {

	}

	public IngresoProductoService(IngresoProductoRepository ingresoProductoRepository) {
		super();
		this.ingresoProductoRepository = ingresoProductoRepository;
	}

	public IngresoProducto guardar(IngresoProducto rol) {
		return ingresoProductoRepository.save(rol);
	}

	public List<IngresoProducto> obtenerTodos() {
		return (List<IngresoProducto>) ingresoProductoRepository.findAll();
	}

	public long total() {
		return ingresoProductoRepository.count();
	}

	public void eliminar(Integer id) {
		ingresoProductoRepository.delete(id);
	}

}
