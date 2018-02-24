package com.tienda.online.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tienda.online.model.Articulo;
import com.tienda.online.repository.ArticuloRepository;

@Service
public class ArticuloService {

	private ArticuloRepository articuloRepository;

	public ArticuloService() {

	}

	public ArticuloService(ArticuloRepository articuloRepository) {
		super();
		this.articuloRepository = articuloRepository;
	}

	public Articulo guardar(Articulo articulo) {
		return articuloRepository.save(articulo);
	}

	public List<Articulo> obtenerTodos() {
		return (List<Articulo>) articuloRepository.findAll();
	}

	public long total() {
		return articuloRepository.count();
	}

	public void eliminar(Integer id) {
		articuloRepository.delete(id);
	}

}
