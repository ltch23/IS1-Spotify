package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dominio.Administrador;
import app.dominio.Cancion;
import app.repositorio.AdministradorRepositorio;
import app.repositorio.CancionRepositorio;

@Service
public class AdministradorServicio {

	@Autowired
	AdministradorRepositorio administradorRepositorio;
	@Transactional
	public Boolean find_admnistrador(Long id)
	{
		
		if(administradorRepositorio.buscarPorId(id)==null) return false;
		return true;
	}
	
	public void save(Administrador admnistrador) {
		Long id = admnistrador.getIdAdministrador();
		if(find_admnistrador(id)==false)
		{
			administradorRepositorio.save(admnistrador);			
		}
		else
		{
			app.repositorio.AdministradorRepositorio.setFixedAdministrador(id);
		}
	}
	public List<Administrador> getTodos(){
		return administradorRepositorio.buscarTodos(); 
	}
	public Administrador get(Long id) {
		return administradorRepositorio.buscarPorId(id);
	}
	
}
