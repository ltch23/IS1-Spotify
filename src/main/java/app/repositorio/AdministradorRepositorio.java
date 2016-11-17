package app.repositorio;

import java.util.List;
import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Administrador;

public interface AdministradorRepositorio extends Repository<Administrador, Long> {
	Administrador save(Administrador administrador);
	
	@Query("SELECT a FROM Administrador a WHERE a.idAdministrador = :id")
	Administrador buscarPorId(@Param("id") Long id);
	
	@Query("SELECT c FROM Administrador c ")
	Collection<Administrador> ColeccionAdministradores();
	
}
