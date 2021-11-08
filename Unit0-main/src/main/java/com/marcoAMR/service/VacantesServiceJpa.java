package com.marcoAMR.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.marcoAMR.model.Usuario;
import com.marcoAMR.model.Vacante;
import com.marcoAMR.repository.VacantesRepository;

@Service
@Primary
public class VacantesServiceJpa implements IntVacantesServices {

	@Autowired
	private VacantesRepository repoVacantes;
	
	@Override
	public List<Vacante> obtenerTodas() {
		return repoVacantes.findAll();
	}

	@Override
	public void guardar(Vacante vacante) {
		repoVacantes.save(vacante);
	}

	@Override
	public void eliminar(Integer idVacante) {
		repoVacantes.deleteById(idVacante);
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		Optional<Vacante> optional = repoVacantes.findById(idVacante);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Vacante> obtenerDestacadas() {
		return repoVacantes.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

	@Override
	public Integer totalEntidades() {
		return repoVacantes.findAll().size();
	}

	
}
