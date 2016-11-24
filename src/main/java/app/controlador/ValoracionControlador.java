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


import app.dominio.Valoracion;
import app.servicio.ValoracionServicio;

@Controller
public class ValoracionControlador {
	@Autowired
	ValoracionServicio ValoracionServicio;
		
	@RequestMapping(value = "/Valoracion", method = RequestMethod.POST)
		String guardarValoracion(@ModelAttribute Valoracion Valoracion, ModelMap model) {
			System.out.println("guardando: " + Valoracion.getIdValoracion());
			ValoracionServicio.save(Valoracion);
			return MostrarValoracion(Valoracion.getIdValoracion(), model);
		}
		@RequestMapping(value = "/agregar-Valoracion", method = RequestMethod.GET)
		String agregarNuevoValoracion(@RequestParam(required = false) Long id, ModelMap model) {
			Valoracion Valoracion= id == null ? new Valoracion() : ValoracionServicio.get(id);
			model.addAttribute("Valoracion", Valoracion);
			return "agregar-Valoracion";
		}
			
		@RequestMapping(value = "/Valoracion", method = RequestMethod.GET)
		String MostrarValoracion(@RequestParam(required = false) Long id, ModelMap model) {
			if (id != null) {
				Valoracion Valoracion= ValoracionServicio.get(id);
				model.addAttribute("Valoracion", Valoracion);
				return "Valoracion";
			} else {
				List<Valoracion> Valoracions = ValoracionServicio.getTodos();
				model.addAttribute("Valoracions", Valoracions);
				return "Valoracions";
			}
			
		}

}



