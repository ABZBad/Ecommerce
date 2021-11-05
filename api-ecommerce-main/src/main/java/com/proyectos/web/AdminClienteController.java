package com.proyectos.web;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyectos.model.Cliente;
import com.proyectos.servicios.ClienteBo;

@RestController
@RequestMapping(path = "/cliente")
public class AdminClienteController {

	@Autowired
	private ClienteBo clienteBo;
	
	 @GetMapping("/buscar/{correo}")
	    public ResponseEntity<Cliente> verCorreo(@PathVariable("correo") String correo){
	        Optional<Cliente> cliente = clienteBo.getByCorreo(correo);
	        return new ResponseEntity(cliente, HttpStatus.OK);
	    }
	 
	 @PostMapping("/guardar")
	 public ResponseEntity<?>save(@RequestBody Cliente cliente){
		 clienteBo.save(cliente);
		 return new ResponseEntity("coche guardado", HttpStatus.CREATED);
	 }
}
