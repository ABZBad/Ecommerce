package com.marcoAMR.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.marcoAMR.model.Usuario;
import com.marcoAMR.model.Vacante;

public interface IntVacantesServices {
	
	public List<Vacante> obtenerTodas();
	public void guardar(Vacante vacante);
	public void eliminar(Integer idVacante);
	public Vacante buscarPorId(Integer idVacante);
	
	public List<Vacante> obtenerDestacadas();
	public Integer totalEntidades();

}
