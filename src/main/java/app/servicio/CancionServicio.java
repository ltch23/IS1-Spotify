package app.servicio;


import java.util.ArrayList;
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
	public Boolean find_cancion(String nombre)
	{
		/*List<Cancion> canciones = CancionRepositorioo.buscarTodos();
		//Cancion canci = CancionRepositorioo.buscarPorId(id);
		for(int i=0;i<canciones.size();i++)
		{
			if(canciones.get(i).getNombre()==nombre)
			{
				return true;
			}
		}
		return false;*/
		if(CancionRepositorioo.buscarPorNombre(nombre)==null) return false;
		return true;
	}

	public void save(Cancion cancion) {
		String name = cancion.getNombre();
		if(find_cancion(name)==false)
		{
			CancionRepositorioo.save(cancion);			
		}
		else
		{
			CancionRepositorio.setFixedCancion(name);
		}
	}

	public Cancion get(Long id) {
		return CancionRepositorioo.buscarPorId(id);
	}
	
	public List<Cancion> getTodos(){
		return CancionRepositorioo.buscarTodos(); 
	}
	public List<Cancion> topTen(){
		List<Cancion> topTen=new ArrayList<Cancion>();
		List<Cancion> orderCanciones=CancionRepositorioo.cancionTop();
		for (int i=0;i<10 && i<orderCanciones.size();i++){
			topTen.add(orderCanciones.get(i));
		}
		return topTen;
	}
}
