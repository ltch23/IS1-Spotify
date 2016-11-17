package app.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Playlist;
//import app.dominio.Cancion;


public interface PlaylistRepository extends Repository<Playlist, Long> {
	Playlist save(Playlist pla);
	@Query("SELECT al FROM Playlist al WHERE al.idPlaylist = :id")
	Playlist buscarPorId(@Param("id") Long id);
}
