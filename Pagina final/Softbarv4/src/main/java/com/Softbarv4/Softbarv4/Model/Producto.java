package com.Softbarv4.Softbarv4.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")

public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto;

	@Column(name = "nombre_producto")
	private String nombre_producto;
	
	@Column(name = "precio")
	private int precio;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="cantidad")
	private int cantidad;
	
	

	@OneToOne
	@JoinColumn(name = "id_categoria")
	private Categoria id_categoria;

	@ManyToMany
	@JoinTable(name = "Detalle_Compra", joinColumns = @JoinColumn(name = "id_producto", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_compra", nullable = false))
	private List<Compra> listCompras;

	@OneToMany(mappedBy = "id_producto_fk", cascade = CascadeType.DETACH)
	private List<Inventario> listapro;

	@OneToMany(mappedBy = "id_productos_fk", cascade = CascadeType.DETACH)
	private List<Pedido> ListaProd;

	public Producto() {
	}

	public Producto(Long id_producto, String nombre_producto, int precio, String descripcion, int cantidad,
			Categoria id_categoria) {
		super();
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.id_categoria = id_categoria;
	}

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Categoria getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
	}
	
}