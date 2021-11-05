package com.proyectos.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.proyectos.model.Producto;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Integer> {
	
	 @Query(value = "{call prueba_producto_consulta(:id_sku)}", nativeQuery = true)
	    Optional <Producto> idProcedure(@Param("id_sku") String id_sku);
	 
	 /*___________________*/
	 
	 
	 @Query(value = "{call prueba_producto_borrado(:id_sku)}", nativeQuery = true)
	    void borrarProcedure(@Param("id_sku") String id_sku);
	 
	 /*___________________*/
	 
	 @Query(value = "{call prueba_producto_insertar(:skuIn, :nombre_productoIn, :precioIn, :descripcionIn, :stock_minimoIn, :stock_maximoIn, :estatus_productoIn, :sub_categoria_categoria_id_categoriaIn)}"
			 , nativeQuery = true)
	    void saveProcedure(
	            @Param("skuIn")String skuIn,
	            @Param("nombre_productoIn")String nombre_productoIn,
	            @Param("precioIn")Double precioIn,
	            @Param("descripcionIn")String descripcionIn,
	            @Param("stock_minimoIn")int stock_minimoIn,
	            @Param("stock_maximoIn")int stock_maximoIn,
	            @Param("estatus_productoIn")int estatus_productoIn,
	            @Param("sub_categoria_categoria_id_categoriaIn")int sub_categoria_categoria_id_categoriaIn
	    );
	 
	 /*____________________________________________________________________________*/
	 
	 
	@Query(value= "{call prueba_producto_modificar(:iDproductoIn, :skuIn, :nombre_productoIn, :precioIn, :descripcionIn, :stock_minimoIn, :stock_maximoIn, :estatus_productoIn, :sub_categoria_categoria_id_categoriaIn)}"
			, nativeQuery = true)
	void updateProcedure(@Param("iDproductoIn") int iDproductoIn,
			@Param("skuIn")String skuIn,
            @Param("nombre_productoIn")String nombre_productoIn,
            @Param("precioIn")Double precioIn,
            @Param("descripcionIn")String descripcionIn,
            @Param("stock_minimoIn")int stock_minimoIn,
            @Param("stock_maximoIn")int stock_maximoIn,
            @Param("estatus_productoIn")int estatus_productoIn,
            @Param("sub_categoria_categoria_id_categoriaIn")int sub_categoria_categoria_id_categoriaIn
		);

	   /*_____________________________________________*/ 
	
}
