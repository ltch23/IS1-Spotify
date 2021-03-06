package app;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.configuracion.WebConfiguracion;

@Controller
@SpringBootApplication

@Import(WebConfiguracion.class)
@EnableAutoConfiguration

public class SpotifyApplication {
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Usado el dia " + new Date()+"              Ingrese a /hello&name=SuNombre para mas informacion";
    }

	public static void main(String[] args) throws Exception{
		SpringApplication.run(SpotifyApplication.class, args);
	}

}
