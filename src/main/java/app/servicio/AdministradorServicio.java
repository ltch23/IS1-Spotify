package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dominio.Administrador;
import app.dominio.Cancion;
import app.repositorio.AdministradorRepositorio;

@Service
public class AdministradorServicio {

	@Autowired
	AdministradorRepositorio administradorRepositorio;
	
	public List<Administrador> getTodos(){
		return administradorRepositorio.buscarTodos(); 
	}
	public Administrador get(Long id) {
		return administradorRepositorio.buscarPorId(id);
	}
	
}
