package app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Persona;
import app.dominio.Playlist;

public interface PersonaRepositorio extends Repository<Persona, Long> {
	Persona save(Persona persona);
	/*
	@Query("SELECT pers FROM Persona pers WHERE pers.id_Persona = :id")
	Persona buscarPorId(@Param("pers") Long id);*/
	@Query("SELECT a FROM Persona a ")
	List<Persona> buscarTodos();
	
	@Query("SELECT al FROM Persona al WHERE al.idPlaylist = :id")
	Persona buscarPorId(@Param("id") Long id);
	
	@Query("SELECT a FROM Persona a WHERE a.nombre =:nombre")
	Persona buscarPorNombre(@Param("nombre") String nombre);
}
