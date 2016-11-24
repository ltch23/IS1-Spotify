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

import app.dominio.Artista;
import app.servicio.ArtistaServicio;

@Controller
public class ArtistaControlador {
	@Autowired
	ArtistaServicio artistaServicio;
	
	@RequestMapping(value = "/artista", method = RequestMethod.POST)
	String guardarArtista(@ModelAttribute Artista artista, ModelMap model) {
		System.out.println("guardando: " + artista.getId());
		artistaServicio.save(artista);
		return MostrarArtista(artista.getId(), model);
	}
	@RequestMapping(value = "/agregar-artista", method = RequestMethod.GET)
	String agregarNuevoArtista(@RequestParam(required = false) Long id, ModelMap model) {
		Artista artista= id == null ? new Artista() : artistaServicio.get(id);
		model.addAttribute("artista", artista);
		return "agregar-artista";
	}
		
	@RequestMapping(value = "/artista", method = RequestMethod.GET)
	String MostrarArtista(@RequestParam(required = false) Long id, ModelMap model) {
		if (id != null) {
			Artista artista= artistaServicio.get(id);
			model.addAttribute("artista", artista);
			return "artista";
		} else {
			List<Artista> artistas = artistaServicio.getTodos();
			model.addAttribute("artistas", artistas);
			return "artistas";
		}
		
	}

}
