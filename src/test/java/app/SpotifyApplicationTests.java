package app;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import app.dominio.Administrador;
import app.dominio.Cancion;
//import app.repositorio.AdministradorRepositorio;
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
		cancion.setNombre("XD");
		cancion.setFecha(new Date());
		cancion.setEstado(true);

		Cancion c = cancionRepositorio.save(cancion);
		Assert.assertNotNull(c.getIdCancion());
		Assert.assertEquals("XD", c.nombre);
		c.setEstado(false);
		cancionRepositorio.save(c);
		Cancion c2 = cancionRepositorio.buscarPorId(c.getIdCancion());
		Assert.assertFalse(c2.getEstado());
	}
	
	/*@Autowired
	AdministradorRepositorio AdmintradorRepositorio;
	
	@Test
	public void testAdministrador()
	{
	 Administrador administrador = new Administrador();
	 Administrador a2 = AdmintradorRepositorio.buscarPorId(administrador.getIdAdministrador());	
	}*/
}
