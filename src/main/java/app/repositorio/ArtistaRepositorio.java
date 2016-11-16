package app.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Artista;
//import app.dominio.Album;

public interface ArtistaRepositorio extends Repository<Artista, Long>{
	//public interface ArtistaRepositorio {

	Artista save(Artista artista);
	
	@Query("SELECT a FROM Artista a WHERE a.idArtista = :id")
	Artista buscarPorId(@Param("id") Long id);
	
	@Query("SELECT a FROM Artista a WHERE a.nombre like '%:nombre'")
	Collection<Artista> buscarArtista(@Param("nombre") String nombre);
		
	//@Query("SELECT Artista.albums FROM Artista WHERE a.nombre like '%:nombre'")
	/*@Query("SELECT a.nombre FROM Artista a")
	String  buscarArtistaPorAlbum();*/
	

}
