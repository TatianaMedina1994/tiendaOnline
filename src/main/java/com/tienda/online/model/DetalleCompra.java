package com.tienda.online.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Detalle_Compra")
public class DetalleCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer cantidad;
	private BigDecimal subtotal;
	private BigDecimal total;
	
	  @ManyToOne ()
	   @JoinColumn(name="compra")
	   @JsonIgnore
	private Compra compra;

	@ManyToOne
	@JoinColumn(name="articulo")
	private Articulo articulo;
	


	public DetalleCompra(Integer id, Integer cantidad, BigDecimal subtotal, BigDecimal total, Compra compra,
			Articulo articulo) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.total = total;
		this.compra = compra;
		this.articulo = articulo;
	}



	public DetalleCompra() {
		
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getCantidad() {
		return cantidad;
	}



	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}



	public BigDecimal getSubtotal() {
		return subtotal;
	}



	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}



	public BigDecimal getTotal() {
		return total;
	}



	public void setTotal(BigDecimal total) {
		this.total = total;
	}



	public Compra getCompra() {
		return compra;
	}



	public void setCompra(Compra compra) {
		this.compra = compra;
	}



	public Articulo getArticulo() {
		return articulo;
	}



	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	

}
