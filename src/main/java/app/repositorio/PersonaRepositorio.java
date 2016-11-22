package app.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Persona;

public interface PersonaRepositorio extends Repository<Persona, Long> {
	Persona save(Persona persona);
	/*
	@Query("SELECT pers FROM Persona pers WHERE pers.id_Persona = :id")
	Persona buscarPorId(@Param("pers") Long id);*/
}
