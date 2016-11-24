package app.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dominio.Playlist;
import app.repositorio.PlaylistRepository;

@Service
public class PlaylistServicio {
	@Autowired
	PlaylistRepository playlistRepositorio;
	
	@Transactional
	public void save(Playlist playlist) {
		playlistRepositorio.save(playlist);
	}

	public Playlist get(Long id) {
		return playlistRepositorio.buscarPorId(id);
	}
	
	public boolean buscarExistencia(String nombplaylist) {
		return playlistRepositorio.buscarPorNombreBool(nombplaylist) ;				
	}
	
	public List<Playlist> getTodos(){
		return playlistRepositorio.buscarTodos(); 
	}
}
