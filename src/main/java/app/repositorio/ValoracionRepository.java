package app.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

//import app.dominio.Cancion;
import app.dominio.Valoracion;


public interface ValoracionRepository extends Repository<Valoracion, Long> {
	Valoracion save(Valoracion val);
	
	//@Query("SELECT val from Valoracion val WHERE val.idValoracion =: idva")
	/*@Query("SELECT val FROM Valoracion val WHERE val.idValoracion =:idval")
	Valoracion buscarPorId(@Param("idval") Long id);*/
	
<<<<<<< HEAD
=======
	//@Query("SELECT val FROM Valoracion val WHERE val.idValoracion =:idval")
	//Valoracion buscarPorId(@Param("idval") Long id);
>>>>>>> 1f189404a5c1a504f9b909d5809bad445ee3ed74
	
	
	}
