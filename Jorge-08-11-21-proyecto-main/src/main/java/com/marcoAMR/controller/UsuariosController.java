package com.marcoAMR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.marcoAMR.model.Perfil;
import com.marcoAMR.model.Usuario;
import com.marcoAMR.service.IntUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private IntUsuariosService usuariosService;
	
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("id") int idUsuario,
			RedirectAttributes atributo) {
		usuariosService.eliminar(idUsuario);
		atributo.addFlashAttribute("msg", "Usuario Eliminado");
		return "redirect:/usuarios/index";
	}
	
	@PostMapping("/guardar")
	public String guardar(Usuario per) {
		usuariosService.guardar(per);
		return "redirect:/usuarios/index";

	}
	@PostMapping("/agregar")
	public String agregar(Usuario per) {
		usuariosService.agregar(per);
		return "redirect:/usuarios/";

	}
	
	@GetMapping("/crear")
	public String crear(Usuario per) {
		return "usuarios/formUsuarios";
	}
	
	
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Usuario> usuarios = usuariosService.obtenerTodos();
		model.addAttribute("usuarios", usuarios);
		return "usuarios/listaUsuarios";
	}
	@GetMapping(value = "/indexPaginado")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Usuario>  lista = usuariosService.buscarTodas(page);
		model.addAttribute("usuarios", lista);
		model.addAttribute("total", 
				usuariosService.numeroEntidades());
		return "usuarios/listaUsuarios";
	}
}
