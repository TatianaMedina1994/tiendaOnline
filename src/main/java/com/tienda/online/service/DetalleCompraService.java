package com.tienda.online.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tienda.online.model.DetalleCompra;
import com.tienda.online.repository.DetalleCompraRepository;

@Service
public class DetalleCompraService {

	private DetalleCompraRepository detalleCompraRepository;

	public DetalleCompraService() {

	}

	public DetalleCompraService(DetalleCompraRepository detalleCompraRepository) {
		super();
		this.detalleCompraRepository = detalleCompraRepository;
	}

	public DetalleCompra guardar(DetalleCompra rol) {
		return detalleCompraRepository.save(rol);
	}

	public List<DetalleCompra> obtenerTodos() {
		return (List<DetalleCompra>) detalleCompraRepository.findAll();
	}

	public long total() {
		return detalleCompraRepository.count();
	}

	public void eliminar(Integer id) {
		detalleCompraRepository.delete(id);
	}

}
