package com.marcoAMR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.marcoAMR.model.Categoria;
import com.marcoAMR.model.Producto;
import com.marcoAMR.service.IntCategoriasService;
import com.marcoAMR.service.IntProductosService;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	@Autowired
	private IntProductosService productosServices;
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("id") int idProducto,
			Model model) {
		Producto producto =  productosServices.buscarPorId(idProducto);
		System.out.println(producto);
		model.addAttribute("producto", producto);
		return "productos/formProducto";
	}
	
	@PostMapping("/guardar")
	//Date Binding(Vincular datos entre la clase mmodelo y el formulario)
	public String guardar(Producto Producto,
			RedirectAttributes attribute) {
		//categoria.setId(categoriasServices.obtenerTodos().size()+1);
		//guardar el objeto de tipo producto
		 productosServices.guardar(Producto);
		attribute.addFlashAttribute("msg", "¡Categoria guardada con exito!");
		//redireccionamiento a la peticion /categorias/index
		return "redirect:/productos/indexPaginado";
	}
	
	
	
	
	/*@PostMapping("/guardar")
	public String guardar(@RequestParam("nombre") String nombre, 
			@RequestParam("descripcion") String descripcion,
			RedirectAttributes attribute) {
		System.out.println("Nombre: "+ nombre);
		System.out.println("Descripcion: "+ descripcion);
		Categoria categoria = new Categoria();
		categoria.setId(categoriasServices.obtenerTodos().size()+1);
		categoria.setNombre(nombre);
		categoria.setDescripcion(descripcion);
		//guardar el objeto de tipo Categoria
		categoriasServices.guardar(categoria);
		attribute.addFlashAttribute("msg", "¡Categoria guardada con exito!");
		//redireccionamiento a la peticion /categorias/index
		return "redirect:/categorias/index";
	}*/
	
	@GetMapping("/crear")
	public String crear(Producto producto) {
		return "productos/formProducto";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id")int idProducto,Model model) {
		System.out.println("IdProducto = " + idProducto);
		//Eliminar una categoria
		 productosServices.eliminar(idProducto);
		//redireccionamiento a la peticion /categorias/index
				return "redirect:/productos/indexPaginado";
		}
	
	@GetMapping(value = "/indexPaginado")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Producto> lista =  productosServices.buscarTodas(page);
	model.addAttribute("productos", lista);
	return "productos/listaProductos";
	}


	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Producto> lista =  productosServices.obtenerTodos();
		for(Producto producto : lista) {
			System.out.println(producto);
		}
		model.addAttribute("productos", lista);
		return "productos/listaProductos";

	}
	

}
