package com.proyectos.model;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_producto;
	private String sku;
	private String nombre_producto;
	private Double precio;
	private String descripcion;
	private Date fecha_creacion;
	private int stock_minimo;
	private int stock_maximo;
	private int estatus_producto;
	private int sub_categoria_categoria_id_categoria;

	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto (int id_producto, String sku, String nombre_producto, 
			Double precio, String descripcion, Date fecha_creacion, int stock_minimo, 
			int stock_maximo, int estatus_producto, int sub_categoria_categoria_id_categoria) {
		this.id_producto = id_producto;
		this.sku = sku;
		this.nombre_producto = nombre_producto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
		this.stock_minimo = stock_minimo;
		this.stock_maximo = stock_maximo;
		this.estatus_producto = estatus_producto;
		this.sub_categoria_categoria_id_categoria = sub_categoria_categoria_id_categoria;
	}


	public int getId_producto() {
		return id_producto;
	}


	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public String getNombre_producto() {
		return nombre_producto;
	}


	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFecha_creacion() {
		return fecha_creacion;
	}


	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}


	public int getStock_minimo() {
		return stock_minimo;
	}


	public void setStock_minimo(int stock_minimo) {
		this.stock_minimo = stock_minimo;
	}


	public int getStock_maximo() {
		return stock_maximo;
	}


	public void setStock_maximo(int stock_maximo) {
		this.stock_maximo = stock_maximo;
	}


	public int getEstatus_producto() {
		return estatus_producto;
	}


	public void setEstatus_producto(int estatus_producto) {
		this.estatus_producto = estatus_producto;
	}


	public int getSub_categoria_categoria_id_categoria() {
		return sub_categoria_categoria_id_categoria;
	}


	public void setSub_categoria_categoria_id_categoria(int sub_categoria_categoria_id_categoria) {
		this.sub_categoria_categoria_id_categoria = sub_categoria_categoria_id_categoria;
	}


	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", sku=" + sku + ", nombre_producto=" + nombre_producto
				+ ", precio=" + precio + ", descripcion=" + descripcion + ", fecha_creacion=" + fecha_creacion
				+ ", stock_minimo=" + stock_minimo + ", stock_maximo=" + stock_maximo + ", estatus_producto="
				+ estatus_producto + ", sub_categoria_categoria_id_categoria=" + sub_categoria_categoria_id_categoria
				+ "]";
	}

	
}
