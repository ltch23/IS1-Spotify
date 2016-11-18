package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import app.configuracion.WebConfiguracion;


@SpringBootApplication

@Import(WebConfiguracion.class)
@EnableAutoConfiguration

public class SpotifyApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(SpotifyApplication.class, args);
	}

}
