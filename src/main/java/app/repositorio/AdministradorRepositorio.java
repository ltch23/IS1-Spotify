package app.repositorio;

import java.util.List;
import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Administrador;
import app.dominio.Artista;

public interface AdministradorRepositorio extends Repository<Administrador, Long> {
	Administrador save(Administrador administrador);
	
	@Query("SELECT a FROM Administrador a ")
	List<Administrador> buscarTodos();
	
	@Query("SELECT a FROM Administrador a WHERE a.idAdministrador = :id")
	Administrador buscarPorId(@Param("id") Long id);
	
	@Query("SELECT c FROM Administrador c ")
	Collection<Administrador> ColeccionAdministradores();
	
	@Modifying
	@Query("UPDATE Administrador c SET c.idAdministrador = ?1 WHERE c.idAdministrador = ?1")
	static
	void setFixedAdministrador(Long idAdministrador) {
		// TODO Auto-generated method stub
		
	}
	
}
