package app.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Cancion;

// http://docs.spring.io/spring-data/jpa/docs/1.10.4.RELEASE/reference/html/
public interface CancionRepositorio extends Repository<Cancion, Long>{
	Cancion save(Cancion cancion);

	@Query("SELECT c FROM Cancion c WHERE c.idCancion = :id")
	Cancion buscarPorId(@Param("id") Long id);

	@Query("SELECT c FROM Cancion c WHERE c.fecha > :fecha")
	Collection<Cancion> cancionesDespuesDe(@Param("fecha") Date fecha);
}
