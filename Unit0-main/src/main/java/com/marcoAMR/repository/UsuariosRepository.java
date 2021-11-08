package com.marcoAMR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marcoAMR.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
	
	@Query(value = "select count(*) from usuarios",
			nativeQuery = true)
	Integer totalEntidades();
	

}
