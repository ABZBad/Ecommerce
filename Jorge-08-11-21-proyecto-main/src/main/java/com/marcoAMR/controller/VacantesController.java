package com.marcoAMR.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.marcoAMR.model.Usuario;
import com.marcoAMR.model.Vacante;
import com.marcoAMR.service.IntCategoriasService;
import com.marcoAMR.service.IntVacantesServices;
import com.marcoAMR.util.Utileria;


@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	
	@Value("${empleossapp.ruta.imageness}")
	private String ruta;
	
	@Autowired
	private IntVacantesServices vacantesService;
	
	@Autowired
	private IntCategoriasService categoriasService;
	
	@GetMapping("/detalles")
	public String detalles(@RequestParam("id") int idVacante,
			Model model) {
		System.out.println("idVacante : " + idVacante);
		model.addAttribute("vacante", vacantesService.buscarPorId(idVacante));
		return "vacantes/detalle";
	}
	
	@PostMapping("/guardar")
	//Data binding o vinculacion de datos
	public String guardar(@Valid  Vacante vacante,BindingResult resultado, 
				Model model,RedirectAttributes attribute,
				 @RequestParam("archivoImagen") MultipartFile multiPart) {
		if (resultado.hasErrors()) {
			for(ObjectError error: resultado.getAllErrors()) {
				System.out.println("Error : " + error.getDefaultMessage());
			}
			//model.addAttribute("categorias", categoriasService.obtenerTodos());
			return "vacantes/formVacante";
		}
		
		if (!multiPart.isEmpty()) {
			// String ruta = "/empleos/img-vacantes/"; // Linux/MAC
			//String ruta = "c:/empleos/imagenes/"; // Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) { // La imagen si se subio
				// Procesamos la variable nombreImagen
				vacante.setImagen(nombreImagen);
			}
		}
		vacante.setId(vacantesService.obtenerTodas().size()+1);
		vacante.setCategoria(categoriasService.buscarPorId(vacante.getCategoria().getId()));
		vacantesService.guardar(vacante);
		System.out.println(vacante);
		attribute.addFlashAttribute("msg","Vacante guardada con exito");
		return "redirect:/vacantes/index";
	}
	
	@GetMapping("/crear")
	public String crear(Vacante vacante) {
		return "vacantes/formVacante";
	}

	@GetMapping("/index")
	public String mostrarIndex() {
		List<Vacante> lista = vacantesService.obtenerTodas();
		for(Vacante v : lista) {
			System.out.println(v);
		}
		
		return "vacantes/listaVacantes";
	}
	
	//******************************
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
      binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
        @Override
        public void setAsText(String text) throws IllegalArgumentException{
          setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }

 

        @Override
        public String getAsText() throws IllegalArgumentException {
          return DateTimeFormatter.ofPattern("dd-MM-yyyy").format((LocalDate) getValue());
        }
      });
    }
	//para cuando tenemos datos comunes en todo el controlador
	//funciona como una variable global y esta disponible para la version actual
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("categorias", categoriasService.obtenerTodos());
		model.addAttribute("vacantes", vacantesService.obtenerTodas());
	}
	
}
