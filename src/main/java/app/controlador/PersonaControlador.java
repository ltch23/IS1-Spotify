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


import app.dominio.Persona;
import app.servicio.PersonaServicio;

@Controller
public class PersonaControlador {
	@Autowired
	PersonaServicio PersonaServicio;
		
	@RequestMapping(value = "/persona", method = RequestMethod.POST)
		String guardarPersona(@ModelAttribute Persona Persona, ModelMap model) {
			System.out.println("guardando: " + Persona.getIdPersona());
			PersonaServicio.save(Persona);
			return MostrarPersona(Persona.getIdPersona(), model);
		}
		@RequestMapping(value = "/agregar-persona", method = RequestMethod.GET)
		String agregarNuevaPersona(@RequestParam(required = false) Long id, ModelMap model) {
			Persona persona= id == null ? new Persona() : PersonaServicio.get(id);
			model.addAttribute("persona", persona);
			return "agregar-persona";
		}
			
		@RequestMapping(value = "/persona", method = RequestMethod.GET)
		String MostrarPersona(@RequestParam(required = false) Long id, ModelMap model) {
			if (id != null) {
				Persona Persona= PersonaServicio.get(id);
				model.addAttribute("persona", Persona);
				return "persona";
			} else {
				List<Persona> Personas = PersonaServicio.getTodos();
				model.addAttribute("personas", Personas);
				return "personas";
			}
			
		}

}