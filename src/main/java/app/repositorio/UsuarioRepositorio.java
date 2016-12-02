package app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.Usuario;

public interface UsuarioRepositorio extends Repository<Usuario, Long> {
	
	Usuario save(Usuario usuario);
	
	@Query("SELECT u FROM Usuario u ")
	List<Usuario> buscarTodos();
	
	@Query("SELECT u FROM Usuario u WHERE u.idUsuario= :id")
	Usuario buscarPorId(@Param("id") Long id);
	
	@Query("SELECT u FROM Usuario u WHERE u.nickname= :nickn  and u.contrasena= :paswd ")
	Usuario validarLogin(@Param("nickn") String nickn, @Param("paswd") String paswd);

	
	//@Query("SELECT u FROM Usuario u WHERE u.nombre =:nombre")
	//Usuario buscarPorNombre(@Param("nombre") String nombre);
}
