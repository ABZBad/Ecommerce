package com.proyectos.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.proyectos.model.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Integer>{
	
	 @Query(value = "{call prueba_cliente_consultar(:correo)}", nativeQuery = true)
	    Optional <Cliente> correoProcedure(@Param("correo") String correo);
	 
	 @Query(value = "{call prueba_cliente_agregar(:nombres, :apellido1, :apellido2, :fecha_nacimiento, :correo, :genero, :codigo_postal_d_cp )}" , nativeQuery = true)
	 void saveCliente(
			 @Param("nombres")String nombres,
			 @Param("apellido1")String apellido1,
			 @Param("apellido2")String apellido2,
			 @Param("fecha_nacimiento")java.util.Date fecha_nacimiento,
			 @Param("correo")String correo,
			 @Param("genero")String genero,
			 @Param("codigo_postal_d_cp")String codigo_postal_d_cp
			 );

}
