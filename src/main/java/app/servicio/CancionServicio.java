package app.servicio;


import java.util.Collection;
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
	public Boolean find_cancion(Long id)
	{
		Collection<Cancion> canciones = CancionRepositorioo.buscarTodos();
		for(int i=0;i<canciones.size();i++)
		{
			if(canciones[i].getIdCancion()==id)
			{
				return 1;
			}
		}
		return 0;
	}
	
	public void save(Cancion cancion) {
		if(!find_cancion(cancion.getIdCancion()))
		{
			CancionRepositorioo.save(cancion);			
		}
	}

	public Cancion get(Long id) {
		return CancionRepositorioo.buscarPorId(id);
	}
	
	public List<Cancion> getTodos(){
		return CancionRepositorioo.buscarTodos(); 
	}
}
