package com.marcoAMR.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.marcoAMR.model.Perfil;


@Service
public class PerfilesServiceImp implements IntPerfilesService {
	
	private List<Perfil> lista;
	
	public PerfilesServiceImp() {
		lista = new LinkedList<Perfil>();
		Perfil per1 = new Perfil();
		per1.setId(1);
		per1.setPerfil("Administrador");
		//*******************************
		Perfil per2 = new Perfil();
		per2.setId(2);
		per2.setPerfil("Profesor");
		//******************************
		Perfil per3 = new Perfil();
		per3.setId(3);
		per3.setPerfil("Alumno");
		//**********************
		Perfil per4 = new Perfil();
		per4.setId(4);
		per4.setPerfil("Administrativo");
		
		lista.add(per1);
		lista.add(per2);
		lista.add(per3);
		lista.add(per4);
	}

	@Override
	public List<Perfil> obtenerTodas() {
		return lista;
	}

	@Override
	public void guardar(Perfil perfil) {
		lista.add(perfil);
	}

	@Override
	public void eliminar(Integer idPerfil) {
		lista.remove(buscarPorId(idPerfil));
	}

	@Override
	public Perfil buscarPorId(Integer idPerfil) {
		for(Perfil p : lista) {
			if(p.getId() == idPerfil) {
				return p;
			}
		}
		return null;
	
	}

}
