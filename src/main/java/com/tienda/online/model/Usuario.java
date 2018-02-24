package com.tienda.online.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nombres;
	private String apellidos;
	private String email;
	private String password;
	private String telefono;
	private String direccion;
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="rol")
	private Rol rol;

	public Usuario() {

	}

	public Usuario(Integer id, String nombres, String apellidos, String email, String password, String telefono,
			String direccion, Date fecha, Rol rol) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fecha = fecha;
		this.rol = rol;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}


}
