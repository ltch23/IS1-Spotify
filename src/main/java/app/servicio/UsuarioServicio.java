package app.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dominio.Usuario;
import app.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	public Usuario userActive;
	
	@Transactional
	public void save(Usuario usuario) {
		usuarioRepositorio.save(usuario);
	}

	public Usuario get(Long id) {
		return usuarioRepositorio.buscarPorId(id);
	}
	
	public List<Usuario> getTodos(){
		return usuarioRepositorio.buscarTodos(); 
	}
	
	public Usuario validarUsuario(String nickn, String paswd){
		return usuarioRepositorio.validarLogin(nickn, paswd);
	} 
	
}

