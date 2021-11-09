package com.marcoAMR.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.marcoAMR.model.Categoria;
import com.marcoAMR.model.Vacante;


@Service
public class VacantesServiceImp implements IntVacantesServices {
	
	private List<Vacante> lista;
	
	public VacantesServiceImp() {
		lista = new LinkedList<Vacante>();
		DateTimeFormatter formato = DateTimeFormatter.
				ofPattern("dd-MM-yyyy");
		try {
			//objetos de tipo vacante
			Vacante v1 = new Vacante();
			v1.setId(1);
			v1.setNombre("Ingeniero en Electronica");
			v1.setDescripcion("Desarrollo de Iot");
			v1.setSalario(1500.00);
			v1.setFecha(LocalDate.parse("02-06-2021", formato));
			v1.setDestacado(1);
			v1.setImagen("logo14.png");
			v1.setEstatus("Creada");
			v1.setDetalles("<h1><strong>Amplia Experiencia</strong></h1>");
			Categoria c1 = new Categoria();
			c1.setId(1);
			c1.setNombre("Ingenieros");
			c1.setDescripcion("Relacionado con las ramas de la ingenieria");
			v1.setCategoria(c1);
		//	***************************************************
			Vacante v2 = new Vacante();
			v2.setId(2);
			v2.setNombre("Programadors Junior");
			v2.setDescripcion("Desarrollo de Aplicaciones Movil");
			v2.setSalario(1200.00);
			v2.setFecha(LocalDate.parse("03-07-2021", formato));
			v2.setDestacado(0);
			v2.setImagen("logo15.png");
			v2.setEstatus("Aprobada");
			v2.setDetalles("<h1><strong>Carreras afines al puesto</strong></h1>");
			Categoria c2 = new Categoria();
			c2.setId(1);
			c2.setNombre("Ingenieros");
			c2.setDescripcion("Relacionado con las ramas de la ingenieria");
			v2.setCategoria(c2);
		//	***************************************************
			Vacante v3 = new Vacante();
			v3.setId(3);
			v3.setNombre("Contador General");
			v3.setDescripcion("Contabilidad y Finanazas");
			v3.setSalario(1100.00);
			v3.setFecha(LocalDate.parse("04-08-2021", formato));
			v3.setDestacado(0);
			//v3.setImagen("logo16.png");
			v3.setEstatus("Eliminada");
			v3.setDetalles("<h1><strong>Amplia Experiencia</strong></h1>");
			Categoria c3 = new Categoria();
			c3.setId(2);
			c3.setNombre("Contadores");
			c3.setDescripcion("Relacionado con contabilidad y finanzas");
			v3.setCategoria(c3);
		//	***************************************************
			Vacante v4 = new Vacante();
			v4.setId(4);
			v4.setNombre("Tecnico General");
			v4.setDescripcion("Mantenimiento de redes de comunicacion");
			v4.setSalario(8000.00);
			v4.setFecha(LocalDate.parse("05-09-2021", formato));
			v4.setDestacado(1);
			v4.setImagen("logo17.png");
			v4.setEstatus("Creada");
			v4.setDetalles("<h1><strong>Amplia Experiencia</strong></h1>");
			Categoria c4 = new Categoria();
			c4.setId(1);
			c4.setNombre("Ingenieros");
			c4.setDescripcion("Relacionado con comunicaciones");
			v4.setCategoria(c4);
		//	***************************************************
			lista.add(v1);
			lista.add(v2);
			lista.add(v3);
			lista.add(v4);
			
		}catch(DateTimeParseException ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		
	}

	@Override
	public List<Vacante> obtenerTodas() {
		return lista;
	}

	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);
	}

	@Override
	public void eliminar(Integer idVacante) {
		lista.remove(buscarPorId(idVacante));
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		for(Vacante v : lista) {
			if( v.getId() == idVacante) {
				return v;
			}
		}
		return null;
	}

	@Override
	public List<Vacante> obtenerDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer totalEntidades() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
