package com.marcoAMR.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.marcoAMR.model.Categoria;
import com.marcoAMR.model.Producto;

public interface PoductosRepository extends JpaRepository<Producto, Integer> {

}
