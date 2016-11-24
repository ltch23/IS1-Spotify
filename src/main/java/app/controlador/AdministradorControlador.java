package app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.solr.core.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.dominio.Administrador;
import app.servicio.AdministradorServicio;

@Controller
public class AdministradorControlador {
	@Autowired
	AdministradorServicio administradorServicio;
	
	@RequestMapping(value = "/administradores", method = RequestMethod.GET)
	String MostrarAdministrador(@RequestParam(required = false) Long id, ModelMap model) {
			
			List<Administrador> administradores = administradorServicio.getTodos();
					
			model.addAttribute("administradores", administradores);
			return "administradores";
	}

}