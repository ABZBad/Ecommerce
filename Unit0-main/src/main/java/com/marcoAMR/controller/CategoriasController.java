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
import com.marcoAMR.service.IntCategoriasService;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private IntCategoriasService categoriasServices;
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("id") int idCategoria,
			Model model) {
		Categoria categoria = categoriasServices.buscarPorId(idCategoria);
		System.out.println(categoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	@PostMapping("/guardar")
	//Date Binding(Vincular datos entre la clase mmodelo y el formulario)
	public String guardar(Categoria categoria,
			RedirectAttributes attribute) {
		//categoria.setId(categoriasServices.obtenerTodos().size()+1);
		//guardar el objeto de tipo Categoria
		categoriasServices.guardar(categoria);
		attribute.addFlashAttribute("msg", "¡Categoria guardada con exito!");
		//redireccionamiento a la peticion /categorias/index
		return "redirect:/categorias/indexPaginado";
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
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id")int idCategoria,Model model) {
		System.out.println("IdCategoria = " + idCategoria);
		//Eliminar una categoria
		categoriasServices.eliminar(idCategoria);
		//redireccionamiento a la peticion /categorias/index
				return "redirect:/categorias/indexPaginado";
		}
	
	@GetMapping(value = "/indexPaginado")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Categoria> lista = categoriasServices.buscarTodas(page);
	model.addAttribute("categorias", lista);
	return "categorias/listaCategorias";
	}


	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista = categoriasServices.obtenerTodos();
		for(Categoria categoria : lista) {
			System.out.println(categoria);
		}
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";

	}

}
