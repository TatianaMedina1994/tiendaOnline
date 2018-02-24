package com.tienda.online.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.model.Categoria;
import com.tienda.online.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public CategoriaService() {

	}

	public CategoriaService(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}

	public Categoria guardar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public List<Categoria> obtenerTodos() {
		return (List<Categoria>) categoriaRepository.findAll();
	}

	public long total() {
		return categoriaRepository.count();
	}

	public void eliminar(String id) {
		categoriaRepository.delete(id);
	}

}
