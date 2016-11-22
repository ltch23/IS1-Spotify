package app.repositorio;


import java.util.List;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Artista;
//import app.dominio.Album;

public interface ArtistaRepositorio extends Repository<Artista, Long>{
	//public interface ArtistaRepositorio {

	Artista save(Artista artista);
	
	@Query("SELECT a FROM Artista a ")
	List<Artista> buscarTodos();
	
	
	@Query("SELECT a FROM Artista a WHERE a.idArtista = :id")
	Artista buscarPorId(@Param("id") Long id);
	
	//@Query("SELECT a FROM Artista a WHERE a.nombre like '%nombre%'")
	@Query("SELECT a FROM Artista a WHERE a.nombre =:nombre")
	List<Artista> buscarPorNombre(@Param("nombre") String nombre);
		
	@Query("SELECT a FROM Artista a WHERE a.fecha >=:fecha")
	List<Artista> buscarPorFecha(@Param("fecha") Date fecha);
	
	@Query("SELECT a FROM Artista a WHERE a.activo =true")
	List<Artista> buscarPorEstado();
	
	//Seleciona la collection de albmums por nombre de artista
	@Query("SELECT a.albums FROM Artista a WHERE a.nombre like '%:nombre%'")
	List<Object[]> buscarAlbums(@Param("nombre") String nombre);
	
}
