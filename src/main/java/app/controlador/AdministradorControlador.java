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

import app.dominio.Administrador;
import app.servicio.AdministradorServicio;

@Controller
public class AdministradorControlador {
	@Autowired
	AdministradorServicio administradorServicio;
	@RequestMapping(value = "/admnistrador", method = RequestMethod.POST)
	String guardarAdmnistrador(@ModelAttribute Administrador admnistrador, ModelMap model) {
		System.out.println("guardando: " + admnistrador.getIdAdministrador());
		administradorServicio.save(admnistrador);
		return MostrarAdministrador(admnistrador.getIdAdministrador(), model);
	}
	
	@RequestMapping(value = "/administrador", method = RequestMethod.GET)
	String MostrarAdministrador(@RequestParam(required = false) Long id, ModelMap model) {
			
			List<Administrador> administradores = administradorServicio.getTodos();
					
			model.addAttribute("administradores", administradores);
			return "administradores";
	}
	@RequestMapping(value = "/agregaradministrador", method = RequestMethod.GET)
	String agregarNuevoAdministrador(@RequestParam(required = false) Long id, ModelMap model) {
		Administrador administrador= id == null ? new Administrador() : administradorServicio.get(id);
		model.addAttribute("administradores", administrador);
		return "agregaradministrador";
	}

}
