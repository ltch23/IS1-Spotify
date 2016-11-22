package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dominio.Artista;
import app.repositorio.ArtistaRepositorio;

@Service
public class ArtistaServicio {

	@Autowired
	ArtistaRepositorio artistaRepositorio;
	
	public List<Artista> getTodos(){
		return artistaRepositorio.buscarTodos(); 
	}
}
