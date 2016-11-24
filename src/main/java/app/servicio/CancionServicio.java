package app.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dominio.Cancion;
import app.repositorio.CancionRepositorio;

@Service
public class CancionServicio {
	@Autowired
	CancionRepositorio CancionRepositorioo;
	
	@Transactional
	public void save(Cancion cancion) {
		CancionRepositorioo.save(cancion);
	}

	public Cancion get(Long id) {
		return CancionRepositorioo.buscarPorId(id);
	}
	
	public List<Cancion> getTodos(){
		return CancionRepositorioo.buscarTodos(); 
	}
}
