package com.marcoAMR.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.marcoAMR.model.Categoria;

@Service
public class CategoriasServiceImp implements IntCategoriasService {
	
	private List<Categoria> lista;
	
	public CategoriasServiceImp() {
		lista = new LinkedList<Categoria>();
		
		Categoria c1 = new Categoria();
		c1.setId(1);
		c1.setNombre("Ingenieros");
		c1.setDescripcion("Relacionado con ramas de ingenieria");
		lista.add(c1);
		/*********************************/
		Categoria c2 = new Categoria();
		c2.setId(2);
		c2.setNombre("Contadores");
		c2.setDescripcion("Relacionado con contabilidad y finanzas");
		lista.add(c2);
		/*********************************/
		Categoria c3 = new Categoria();
		c3.setId(3);
		c3.setNombre("Auxiliares de limpieza");
		c3.setDescripcion("Relacionado con limpiezas de oficinas");
		lista.add(c3);
		/********************************/
		Categoria c4 = new Categoria();
		c4.setId(4);
		c4.setNombre("Vigilancia");
		c4.setDescripcion("Relacionado  con seguridad");
		lista.add(c4);

	}


	@Override
	public List<Categoria> obtenerTodos() {
		return lista;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for(Categoria c : lista) {
			if ( c.getId() == idCategoria) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void guardar(Categoria categoria) {
		lista.add(categoria);
	}

	@Override
	public void eliminar(Integer idCategoria) {
		lista.remove(buscarPorId(idCategoria));
	}


	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

} 
