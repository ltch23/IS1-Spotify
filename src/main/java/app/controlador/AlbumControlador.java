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

import app.dominio.Album;
import app.servicio.AlbumServicio;

import app.dominio.Artista;
import app.servicio.ArtistaServicio;


@Controller

public class AlbumControlador {

	
	ArtistaServicio artistaServicio;
	
		@Autowired
		AlbumServicio albumServicio;
		
		@RequestMapping(value = "/album", method = RequestMethod.POST)
		String guardarAlbum(@ModelAttribute Album album, ModelMap model) {
			System.out.println("guardando: " + album.getId());
			albumServicio.save(album);
			return MostrarAlbum(album.getId(), model);
		}
		@RequestMapping(value = "/agregar-album", method = RequestMethod.GET)
		String addNuevoAlbum(@RequestParam(required = false) Long id, Long idAr,ModelMap model) {
			Album album = id == null ? new Album() : albumServicio.get(id);
			model.addAttribute("album", album);
			return "agregar-album";
		}
			
		@RequestMapping(value = "/album", method = RequestMethod.GET)
		String MostrarAlbum(@RequestParam(required = false) Long id, ModelMap model) {
			if (id != null) {
				Album album= albumServicio.get(id);
				model.addAttribute("album", album);
				return "album";
			} else {
				List<Album> albums = albumServicio.getTodos();
				model.addAttribute("albums", albums);
				return "albums";
			}
			
		}
	
}
