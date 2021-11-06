package com.proyectos.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyectos.model.Producto;
import com.proyectos.servicios.ProductoBo;


@RestController
@RequestMapping(path = "/producto")
public class AdminProductoController {

	@Autowired
	private ProductoBo productoBo;
	
		@GetMapping("/lista")
		public ResponseEntity<List<Producto>> lista(){
			List <Producto> lista = productoBo.lista();
			return new ResponseEntity(lista, HttpStatus.OK);
		}
	
	    @GetMapping("/buscar/{sku}")
	    public ResponseEntity<Producto> verId(@PathVariable("sku") String sku){
	        Optional<Producto> producto = productoBo.getById(sku);
	        return new ResponseEntity(producto, HttpStatus.OK);
	    }
	   
	   /*___________________*/
	     @DeleteMapping("/borrar/{sku}")
	    public ResponseEntity<?> borrar(@PathVariable("sku")String sku){
	        productoBo.borrarProcedure(sku);
	        return new ResponseEntity("eliminado", HttpStatus.OK);
	    }
	   
	   /*___________________*/
	   
	     @PostMapping("/add")
	    public ResponseEntity<?> save(@RequestBody Producto producto){
	        productoBo.saveProcedure(producto);
	        return new ResponseEntity( "producto guardado", HttpStatus.CREATED);
	    }
	   
	   /*___________________*/
	   
	   @PutMapping("/update")
	   public ResponseEntity<?> update(@RequestBody Producto producto){
		   productoBo.updateProcedure(producto);
		   return new ResponseEntity("producto actualizado", HttpStatus.CREATED);
	   }
	   

}
