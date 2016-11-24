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
		
	@RequestMapping(value = "/Persona", method = RequestMethod.POST)
		String guardarPersona(@ModelAttribute Persona Persona, ModelMap model) {
			System.out.println("guardando: " + Persona.getIdPersona());
			PersonaServicio.save(Persona);
			return MostrarPersona(Persona.getIdPersona(), model);
		}
		@RequestMapping(value = "/agregar-Persona", method = RequestMethod.GET)
		String agregarNuevoPersona(@RequestParam(required = false) Long id, ModelMap model) {
			Persona Persona= id == null ? new Persona() : PersonaServicio.get(id);
			model.addAttribute("Persona", Persona);
			return "agregar-Persona";
		}
			
		@RequestMapping(value = "/Persona", method = RequestMethod.GET)
		String MostrarPersona(@RequestParam(required = false) Long id, ModelMap model) {
			if (id != null) {
				Persona Persona= PersonaServicio.get(id);
				model.addAttribute("Persona", Persona);
				return "Persona";
			} else {
				List<Persona> Personas = PersonaServicio.getTodos();
				model.addAttribute("Personas", Personas);
				return "Personas";
			}
			
		}

}