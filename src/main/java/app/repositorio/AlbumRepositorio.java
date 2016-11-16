package app.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Album;
import app.dominio.Artista;

public interface AlbumRepositorio extends Repository<Album, Long> {
	Album save(Album album);
	
	@Query("SELECT al FROM Album al WHERE al.idAlbum = :id")
	Album buscarPorId(@Param("id") Long id);
	
	@Query("SELECT al FROM Album al WHERE al.nombre like '%:nombre'")
	Collection<Album> buscarAlbum(@Param("nombre") String nombre);
	
	/*@Query("SELECT * FROM Album INNER JOIN Artista ON Artista.id_artista=al.artista_id_artista")
	//Collection<Album> buscarArtistaPorAlbum(@Param("nombre") String nombre);
	Collection<Album> buscarArtistaPorAlbum();*/

	
	


}
