package com.marcoAMR.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.marcoAMR.model.Categoria;
import com.marcoAMR.repository.CategoriasRepository;


@Service
@Primary
public class CategoriasServiceJpa implements IntCategoriasService {
	
	@Autowired
	private CategoriasRepository repoCategorias;
	

	@Override
	public List<Categoria> obtenerTodos() {
		// TODO Auto-generated method stub
		return repoCategorias.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional = repoCategorias.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Categoria categoria) {
		repoCategorias.save(categoria);
	}

	@Override
	public void eliminar(Integer idCategoria) {
		repoCategorias.deleteById(idCategoria);
	}

	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		return repoCategorias.findAll(page);
	}

}
