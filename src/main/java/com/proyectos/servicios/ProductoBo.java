package com.proyectos.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectos.model.Producto;
import com.proyectos.repository.ProductoDao;

@Service
public class ProductoBo {

	@Autowired
	private ProductoDao Producto;
	
	public List <Producto> lista(){
		return Producto.findAll();
	}
	
	public Optional <Producto> getById(String sku){
        return Producto.idProcedure(sku);
    }
	
	 /*___________________*/
	
	public void borrarProcedure(String sku){
        Producto.borrarProcedure(sku);
    }
	
	 /*___________________*/
	
	 public void saveProcedure(Producto producto){
	        Producto.saveProcedure
	        		(producto.getSku(), 
	        		producto.getNombre_producto(), 
	        		producto.getPrecio(), 
	        		producto.getDescripcion(),
	        		producto.getStock_minimo(),
	        		producto.getStock_maximo(),
	        		producto.getEstatus_producto(),
	        		producto.getSub_categoria_categoria_id_categoria());
	    }
	 
	 /*___________________*/
	 
	 public void updateProcedure(Producto producto) {
		 Producto.updateProcedure(producto.getId_producto(),
				 producto.getSku(), 
	        		producto.getNombre_producto(), 
	        		producto.getPrecio(), 
	        		producto.getDescripcion(),
	        		producto.getStock_minimo(),
	        		producto.getStock_maximo(),
	        		producto.getEstatus_producto(),
	        		producto.getSub_categoria_categoria_id_categoria()
	        		);
	 }

}
