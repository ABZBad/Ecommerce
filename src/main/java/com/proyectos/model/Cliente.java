package com.proyectos.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_cliente;
	private String nombres;
	private String apellido1;
	private String apellido2;
	private Date fecha_nacimiento;
	private String correo;
	private String genero;
	private int estatus_cliente;
	private String codigo_postal_d_cp;
	 
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEstatus_cliente() {
		return estatus_cliente;
	}

	public void setEstatus_cliente(int estatus_cliente) {
		this.estatus_cliente = estatus_cliente;
	}

	public String getCodigo_postal_d_cp() {
		return codigo_postal_d_cp;
	}

	public void setCodigo_postal_d_cp(String codigo_postal_d_cp) {
		this.codigo_postal_d_cp = codigo_postal_d_cp;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nombres=" + nombres + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", fecha_nacimiento=" + fecha_nacimiento + ", correo=" + correo
				+ ", genero=" + genero + ", estatus_cliente=" + estatus_cliente + ", codigo_postal_d_cp="
				+ codigo_postal_d_cp + "]";
	}
	
}
