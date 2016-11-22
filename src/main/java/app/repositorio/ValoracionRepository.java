package app.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

//import app.dominio.Cancion;
import app.dominio.Valoracion;


public interface ValoracionRepository extends Repository<Valoracion, Long> {
	Valoracion save(Valoracion valoracion);
	
	@Query("SELECT val FROM Valoracion val WHERE val.idValoracion =:id")
	Valoracion buscarPorIdValoracion(@Param("id") Long id);

	//@Query("SELECT val FROM Valoracion val WHERE val.idUsuario =: idc and val.cancion =: idu")
	//Valoracion buscarPorIdCancionYUsuario(@Param("idc") Long idc, @Param("idu") Long idu);

	
	
	}
