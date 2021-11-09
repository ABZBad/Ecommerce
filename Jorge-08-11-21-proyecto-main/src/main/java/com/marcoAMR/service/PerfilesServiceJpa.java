package com.marcoAMR.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.marcoAMR.model.Perfil;
import com.marcoAMR.repository.PerfilesRepository;

@Service
@Primary
public class PerfilesServiceJpa implements IntPerfilesService {
	
	@Autowired
	private PerfilesRepository repoPerfiles;

	@Override
	public List<Perfil> obtenerTodas() {
		// TODO Auto-generated method stub
		return repoPerfiles.findAll();
	}

	@Override
	public void guardar(Perfil perfil) {
		repoPerfiles.save(perfil);
	}

	@Override
	public void eliminar(Integer idPerfil) {
		repoPerfiles.deleteById(idPerfil);
	}

	@Override
	public Perfil buscarPorId(Integer idPerfil) {
		Optional<Perfil> optional = repoPerfiles.findById(idPerfil);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	

}
