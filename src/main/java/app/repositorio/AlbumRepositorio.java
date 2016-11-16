package app.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Album;
//import app.dominio.Artista;

public interface AlbumRepositorio extends Repository<Album, Long> {
	Album save(Album album);
	
	@Query("SELECT al FROM Album al WHERE al.idAlbum = :id")
	Album buscarPorId(@Param("id") Long id);
	
	@Query("SELECT al FROM Album al WHERE al.nombre like '%:nombre%'")
	Collection<Album> buscarPorNombre(@Param("nombre") String nombre);
	
	@Query("SELECT al FROM Artista al WHERE al.fecha >=:fecha")
	Collection<Album> buscarPorFecha(@Param("fecha") Date fecha);

	@Query("SELECT al FROM Artista al WHERE al.activo =true")
	Collection<Album> buscarPorEstado();

	//Seleciona artista de un album por nombre
	@Query("SELECT al.artista FROM Album al  WHERE al.nombre like '%:nombre%'")
	Collection<Object[]> buscarArtista(@Param("nombre") String nombre);
	
}
