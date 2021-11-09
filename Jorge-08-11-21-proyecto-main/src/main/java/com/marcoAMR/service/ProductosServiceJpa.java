package com.marcoAMR.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.marcoAMR.model.Categoria;
import com.marcoAMR.model.Producto;
import com.marcoAMR.repository.CategoriasRepository;
import com.marcoAMR.repository.PoductosRepository;


@Service
@Primary
public class ProductosServiceJpa implements IntProductosService {
	
	@Autowired
	private PoductosRepository repoProductos;
	

	@Override
	public List<Producto> obtenerTodos() {
		// TODO Auto-generated method stub
		return repoProductos.findAll();
	}

	@Override
	public Producto buscarPorId(Integer idProducto) {
		Optional<Producto> optional = repoProductos.findById(idProducto);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Producto producto) {
		repoProductos.save(producto);
	}

	@Override
	public void eliminar(Integer idProducto) {
		repoProductos.deleteById(idProducto);
	}

	@Override
	public Page<Producto> buscarTodas(Pageable page) {
		return repoProductos.findAll(page);
	}

}
