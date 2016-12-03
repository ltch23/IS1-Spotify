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


import app.dominio.Usuario;
import app.servicio.UsuarioServicio;

@Controller
public class UsuarioControlador {
	@Autowired
	UsuarioServicio usuarioServicio;
		
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
		String guardarUsuario(@ModelAttribute Usuario usuario, ModelMap model) {
			System.out.println("guardando: " + usuario.getIdUsuario());
			usuarioServicio.save(usuario);
			return MostrarUsuario(usuario.getIdUsuario(), model);
		}
		@RequestMapping(value = "/agregar-usuario", method = RequestMethod.GET)
		String agregarNuevoUsuario(@RequestParam(required = false) Long id, ModelMap model) {
			Usuario usuario= id == null ? new Usuario() : usuarioServicio.get(id);
			model.addAttribute("usuario", usuario);
			return "agregar-usuario";
		}
			
		@RequestMapping(value = "/usuario", method = RequestMethod.GET)
		String MostrarUsuario(@RequestParam(required = false) Long id, ModelMap model) {
			if (id != null) {
				Usuario usuario= usuarioServicio.get(id);
				model.addAttribute("usuario", usuario);
				return "usuario";
			} else {
				List<Usuario> usuarios= usuarioServicio.getTodos();
				model.addAttribute("usuarios", usuarios);
				return "usuarios";
			}
		}

		@RequestMapping(value= "/validar-usuario",method = RequestMethod.GET)
		String validarUsuario(@RequestParam(required = true) String name, @RequestParam(required = true) String password, ModelMap model){
			Usuario usuario= usuarioServicio.validarUsuario(name,password);
			if(usuario!=null){
				model.addAttribute("usuario",usuario);
				return "usuario";
			} else {
				System.out.println("pase2");
				return "home";
			}
		}
}
