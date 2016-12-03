package app.repositorio;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Artista;
import app.dominio.Cancion;

// http://docs.spring.io/spring-data/jpa/docs/1.10.4.RELEASE/reference/html/
public interface CancionRepositorio extends Repository<Cancion, Long>{
	Cancion save(Cancion canci);
	//Cancion Update();

	@Query("SELECT a FROM Cancion a ")
	List<Cancion> buscarTodos();
	
	@Query("SELECT c FROM Cancion c WHERE c.idCancion = :id")
	Cancion buscarPorId(@Param("id") Long id);
	
	@Query("SELECT c FROM Cancion c WHERE c.nombre = :nombre")
	Cancion buscarPorNombre(@Param("nombre") String nombre);
	
	@Modifying
	@Query("UPDATE Cancion c SET c.nombre = ?1 WHERE c.nombre = ?1")
	static
	void setFixedCancion(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Query("SELECT c FROM Cancion c WHERE c.fecha > :fecha")
	Collection<Cancion> cancionesDespuesDe(@Param("fecha") Date fecha);
}
