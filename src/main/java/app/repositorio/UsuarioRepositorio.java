package app.repositorio;

import org.springframework.data.repository.Repository;

import app.dominio.Usuario;

public interface UsuarioRepositorio extends Repository<Usuario, Long>{
	Usuario save (Usuario user);
	

}
