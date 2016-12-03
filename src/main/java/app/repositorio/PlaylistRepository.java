package app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;


import app.dominio.Playlist;



public interface PlaylistRepository extends Repository<Playlist, Long> {
	Playlist save(Playlist playlist);

	@Query("SELECT a FROM Playlist a WHERE a.activo = TRUE")
	List<Playlist> buscarTodos();
	
	@Query("SELECT al FROM Playlist al WHERE al.idPlaylist = :id")
	Playlist buscarPorId(@Param("id") Long id);
	
	@Query("SELECT a FROM Playlist a WHERE a.nombre =:nombre")
	Playlist buscarPorNombre(@Param("nombre") String nombre);
}
