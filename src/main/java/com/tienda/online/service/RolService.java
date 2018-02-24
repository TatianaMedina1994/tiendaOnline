package com.tienda.online.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.online.model.Rol;
import com.tienda.online.repository.RolRepository;

@Service
public class RolService {

	@Autowired
	private RolRepository rolRepository;

	public RolService() {

	}

	public RolService(RolRepository rolRepository) {
		super();
		this.rolRepository = rolRepository;
	}

	public Rol guardar(Rol rol) {
		return rolRepository.save(rol);
	}

	public List<Rol> obtenerTodos() {
		return (List<Rol>) rolRepository.findAll();
	}

	public long total() {
		return rolRepository.count();
	}

	public void eliminar(Integer id) {
		rolRepository.delete(id);
	}
}
