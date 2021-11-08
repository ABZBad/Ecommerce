package com.marcoAMR.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcoAMR.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
