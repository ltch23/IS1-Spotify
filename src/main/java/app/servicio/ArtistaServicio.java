package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dominio.Artista;
import app.repositorio.ArtistaRepositorio;

@Service
public class ArtistaServicio {

	@Autowired
	ArtistaRepositorio artistaRepositorio;
	
	@Transactional
	public void save(Artista artista) {
			artistaRepositorio.save(artista);
	}

	public Artista get(Long id) {
		return artistaRepositorio.buscarPorId(id);
	}
	
	public List<Artista> getTodos(){
		return artistaRepositorio.buscarTodos(); 
	}
}
