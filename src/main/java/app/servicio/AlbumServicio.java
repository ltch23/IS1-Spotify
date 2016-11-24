package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dominio.Album;
import app.repositorio.AlbumRepositorio;

@Service
public class AlbumServicio {

	@Autowired
	AlbumRepositorio albumRepositorio;
	
	@Transactional
	public void save(Album album)
	{
			albumRepositorio.save(album);
	}

	public Album  get(Long id) {
		return albumRepositorio.buscarPorId(id);
	}
	
	public List<Album> getTodos(){
		return albumRepositorio.buscarTodos(); 
	}
}
