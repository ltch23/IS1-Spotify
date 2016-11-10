package app;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import app.dominio.Cancion;
import app.repositorio.CancionRepositorio;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpotifyApplicationTests {

	@Autowired
	CancionRepositorio cancionRepositorio;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCanciones() {
		Cancion cancion = new Cancion();
		cancion.m_nombre_cancion = "XD";
		cancion.set_fecha_cancion(new Date());
		cancion.set_estado_cancion(true);

		Cancion c = cancionRepositorio.save(cancion);
		Assert.assertNotNull(c.get_id_cancion());
		Assert.assertEquals("XD", c.m_nombre_cancion);
		c.set_estado_cancion(false);
		cancionRepositorio.save(c);
		Cancion c2 = cancionRepositorio.buscarPorId(c.get_id_cancion());
		Assert.assertFalse(c2.get_estado_cancion());
	}
}
