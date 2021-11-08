package com.marcoAMR.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.marcoAMR.model.Categoria;
import com.marcoAMR.model.Producto;

public interface IntProductosService {
	
	public List<Producto> obtenerTodos();
	public Producto buscarPorId(Integer idProducto);
	public void guardar(Producto producto);
	public void eliminar(Integer idProducto);
	
	public Page<Producto>buscarTodas(Pageable page);

}
