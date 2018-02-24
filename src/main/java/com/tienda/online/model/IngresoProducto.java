package com.tienda.online.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ingreso_Producto")
public class IngresoProducto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer cantidad;
	
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;
	private BigDecimal total;
	
	@ManyToOne
	@JoinColumn(name="articulo")
	private Articulo articulo;
	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	public IngresoProducto() {

	}

	public IngresoProducto(Integer cantidad, Date fechaIngreso, BigDecimal total, Articulo articulo, Usuario usuario) {
		super();
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
		this.total = total;
		this.articulo = articulo;
		this.usuario = usuario;
	}



	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
