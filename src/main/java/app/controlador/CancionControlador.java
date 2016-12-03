package app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.solr.core.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import app.dominio.Cancion;
import app.servicio.CancionServicio;

@Controller
public class CancionControlador {
	@Autowired
	CancionServicio cancionServicio;
		
	@RequestMapping(value = "/cancion", method = RequestMethod.POST)
		String guardarCancion(@ModelAttribute Cancion cancion, ModelMap model) {
			System.out.println("guardando: " + cancion.getIdCancion());
			cancionServicio.save(cancion);
			return MostrarCancion(cancion.getIdCancion(), model);
		}
		@RequestMapping(value = "/agregar-cancion", method = RequestMethod.GET)
		String agregarNuevaCancion(@RequestParam(required = false) Long id, ModelMap model) {
			Cancion cancion= id == null ? new Cancion() : cancionServicio.get(id);
			model.addAttribute("cancion", cancion);
			return "agregar-cancion";
		}

		@RequestMapping(value = "/cancion", method = RequestMethod.GET)
		String MostrarCancion(@RequestParam(required = false) Long id, ModelMap model) {
			if (id != null) {
				Cancion cancion= cancionServicio.get(id);
				model.addAttribute("cancion", cancion);
				return "cancion";
			} else {
				List<Cancion> canciones = cancionServicio.getTodos();
				model.addAttribute("canciones", canciones);
				return "canciones";
			}
			
		}
		
		@RequestMapping(value = "/top-ten", method= RequestMethod.GET)
		String MostrarCanciones(ModelMap model){
			List<Cancion> canciones = cancionServicio.topTen();
			model.addAttribute("canciones",canciones);
			return "canciones";
		}
}



