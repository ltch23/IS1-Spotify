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
import app.dominio.Valoracion;
import app.repositorio.AdministradorRepositorio;
import app.repositorio.CancionRepositorio;
import app.repositorio.ValoracionRepositorio;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpotifyApplicationTests {

	@Autowired
	CancionRepositorio cancionRepositorio;
	@Autowired
	ValoracionRepositorio valoracionRepositorio;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCanciones() {
		Cancion cancion = new Cancion();
		cancion.setNombre("XD");
		//cancion.nombre="XD";
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
	
	@Test 
	public void testValoracion(){
		Cancion cancion = new Cancion();
		cancion.setNombre("wwD");
		cancion.setFecha(new Date());
		cancion.setEstado(true);	

		Cancion c2 = cancionRepositorio.save(cancion);
		
		
		Valoracion val, val2;
		val = new Valoracion();
		val.setPuntuacion(5);  //PUNTUACION DE LA CANCIAON
		val.setCancion(cancion);
		val2 = valoracionRepositorio.save(val);

		/* Intento de cambiar la puntutacion
		 * Assert.assertNotNull(val2.getIdValoracion());
		val2.setPuntuacion(7);  //PUNTUACION DE LA CANCIAON
		valoracionRepository.save(val2);
		Assert.assertEquals("7",val2.getPuntuacion());*/
	}
	
	
	@Autowired
	AdministradorRepositorio AdmintradorRepositorio;
	
	@Test
	public void testAdministrador()
	{
	 Administrador administrador = new Administrador();
	 AdmintradorRepositorio.buscarPorId(administrador.getIdAdministrador());	
	 AdmintradorRepositorio.ColeccionAdministradores();	

	}
}