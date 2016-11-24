package app.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dominio.Persona;
import app.repositorio.PersonaRepositorio;

@Service
public class PersonaServicio {
	@Autowired
	PersonaRepositorio PersonaRepositorio;
	
	@Transactional
	public void save(Persona Persona) {
		PersonaRepositorio.save(Persona);
	}

	public Persona get(Long id) {
		return PersonaRepositorio.buscarPorId(id);
	}
	
	public List<Persona> getTodos(){
		return PersonaRepositorio.buscarTodos(); 
	}
}
