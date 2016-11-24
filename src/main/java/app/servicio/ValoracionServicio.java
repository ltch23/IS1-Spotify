package app.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dominio.Valoracion;
import app.repositorio.ValoracionRepository;

@Service
public class ValoracionServicio {
	@Autowired
	ValoracionRepository ValoracionRepositorio;
	
	@Transactional
	public void save(Valoracion Valoracion) {
		ValoracionRepositorio.save(Valoracion);
	}

	public Valoracion get(Long id) {
		return ValoracionRepositorio.buscarPorId(id);
	}
	
	public List<Valoracion> getTodos(){
		return ValoracionRepositorio.buscarTodos(); 
	}
}
