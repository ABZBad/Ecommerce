package com.marcoAMR.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//JavaBean o Pojo
//anotaciones JPA
@Entity
@Table(name="Productos")
public class Producto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String producto;
	private String marca;
	private String modelo;
	private Integer precio;
	private String puertos;
	private String accesorios;
	private String color;
	private String descripcion;
	private LocalDate fecha;
	private String imagen = "logo.png";
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public String getPuertos() {
		return puertos;
	}
	public void setPuertos(String puertos) {
		this.puertos = puertos;
	}
	public String getAccesorios() {
		return accesorios;
	}
	public void setAccesorios(String accesorios) {
		this.accesorios = accesorios;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", producto=" + producto + ", marca=" + marca + ", modelo=" + modelo + ", precio="
				+ precio + ", puertos=" + puertos + ", accesorios=" + accesorios + ", color=" + color + ", descripcion="
				+ descripcion + ", fecha=" + fecha + ", imagen=" + imagen + "]";
	}
	
	

	
	
}
