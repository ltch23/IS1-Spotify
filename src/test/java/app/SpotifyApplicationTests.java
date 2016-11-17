package app;

import java.util.Collection;
import java.util.List;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import app.dominio.Administrador;

import app.dominio.Artista;
import app.dominio.Album;

import app.dominio.Cancion;
import app.dominio.Valoracion;
import app.repositorio.AdministradorRepositorio;
import app.repositorio.AlbumRepositorio;
import app.repositorio.ArtistaRepositorio;
import app.repositorio.CancionRepositorio;
import app.repositorio.PersonaRepositorio;
import app.repositorio.UsuarioRepositorio;
import app.repositorio.ValoracionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpotifyApplicationTests {

	@Autowired
	CancionRepositorio cancionRepositorio;
	@Autowired
	ValoracionRepository valoracionRepository;
	@Autowired
	ArtistaRepositorio artistaRepositorio;
	@Autowired
	AlbumRepositorio albumRepositorio;
	@Autowired
	PersonaRepositorio personaRepositorio;
	@Autowired
	UsuarioRepositorio usuarioRepositorio;	
	
	
	@Test
	public void testArtistaAndAlbum(){
		Artista artista1= new  Artista();
		artista1.setNombre("Churrumino");
		artista1.setFecha(new Date());
		artista1.setEstado(true);
				
		Album album1 = new  Album();
		album1.setNombre("larala larala");
		album1.setFecha(new Date());
		album1.setEstado(true);
		
		album1.setArtista(artista1);
		//artista1.setAlbum(album1);
		Artista a1= artistaRepositorio.save(artista1);
		Album al1=albumRepositorio.save(album1);
		
		Assert.assertEquals("Churrumino", a1.getNombre());
		Assert.assertEquals("Churrumino", al1.getArtista().getNombre());
		
		List<Artista> artistas2=artistaRepositorio.buscarPorEstado();
		List<Artista> artistas=artistaRepositorio.buscarPorNombre(a1.getNombre());
		
		
		for(int i=0;i<artistas.size();i++){
		if(artistas.get(i).getNombre()=="Churrumino"){
			continue;
		}
		}
		
		//Assert.assertEquals("larala larala", al1.getNombre());
		
		
			
	}
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testCanciones() {
		Cancion cancion = new Cancion();
		cancion.setNombre("XwdwD");
		cancion.setFecha(new Date());
		cancion.setEstado(true);

		Cancion c = cancionRepositorio.save(cancion);
		Assert.assertNotNull(c.getIdCancion());
		Assert.assertEquals("XwdwD", c.nombre);
		c.setEstado(false);
		cancionRepositorio.save(c);
		Cancion c2 = cancionRepositorio.buscarPorId(c.getIdCancion());
		Assert.assertFalse(c2.getEstado());
	}
	
	/*
	
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
		val2 = valoracionRepository.save(val);
	*/	
		/* Intento de cambiar la puntutacion
		 * Assert.assertNotNull(val2.getIdValoracion());
		val2.setPuntuacion(7);  //PUNTUACION DE LA CANCIAON
		valoracionRepository.save(val2);
		Assert.assertEquals("7",val2.getPuntuacion());*/
	//}
	
	
	
	
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
