package com.proyectos.servicios;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectos.model.Cliente;
import com.proyectos.repository.ClienteDao;

@Service
public class ClienteBo {

	@Autowired
	private ClienteDao Cliente;
	
	public Optional <Cliente> getByCorreo(String correo){
        return Cliente.correoProcedure(correo);
    }
	
	public void save(Cliente cliente) {
		Cliente.saveCliente(
				cliente.getNombres(), 
				cliente.getApellido1(), 
				cliente.getApellido2(),
				cliente.getFecha_nacimiento(),
				cliente.getCorreo(),
				cliente.getGenero(),
				cliente.getCodigo_postal_d_cp()
				);
	}
	
}
