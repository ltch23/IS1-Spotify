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


import app.dominio.Playlist;
import app.servicio.PlaylistServicio;

@Controller
public class PlaylistControlador {
	@Autowired
	PlaylistServicio playlistServicio;
		
	@RequestMapping(value = "/playlist", method = RequestMethod.POST)
		String guardarPlaylist(@ModelAttribute Playlist playlist, ModelMap model) {
			System.out.println("guardando: " + playlist.getIdPlaylist());
			playlistServicio.save(playlist);
			return MostrarPlaylist(playlist.getIdPlaylist(), model);
		}
		@RequestMapping(value = "/agregar-playlist", method = RequestMethod.GET)
		String agregarNuevoPlaylist(@RequestParam(required = false) Long id, ModelMap model) {
			Playlist playlist= id == null ? new Playlist() : playlistServicio.get(id);
			model.addAttribute("playlist", playlist);
			return "agregar-playlist";
		}
			
		@RequestMapping(value = "/playlist", method = RequestMethod.GET)
		String MostrarPlaylist(@RequestParam(required = false) Long id, ModelMap model) {
			if (id != null) {
				Playlist playlist= playlistServicio.get(id);
				model.addAttribute("playlist", playlist);
				return "playlist";
			} else {
				List<Playlist> playlists = playlistServicio.getTodos();
				model.addAttribute("playlists", playlists);
				return "playlists";
			}
			
		}

}



