package com.marcoAMR.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.marcoAMR.model.Usuario;

public interface IntUsuariosService {
	
	public List<Usuario> obtenerTodos();
	public void guardar(Usuario usuario);
	public void agregar(Usuario usuario);
	public void eliminar(Integer idUsuario);
	public Usuario buscarPorId(Integer idUsuario);
	
	public Page<Usuario>buscarTodas(Pageable page);	
	public Integer numeroEntidades();
}
