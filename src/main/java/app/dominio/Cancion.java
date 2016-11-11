package app.dominio;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Cancion {
	@Id
	@SequenceGenerator(name = "cancion_id_generator", sequenceName = "cancion_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancion_id_generator")
	
	private Long idCancion;

	@Column(length = 256, nullable = false, unique= false)
	public String nombre;
	
	@Column(nullable=false)
	private boolean activo;
	
	@Column(length=256)
	private String letra;
	
	@Column(nullable=false)
	private Date fecha;
	
	private Integer numReproducciones;

	@OneToMany(mappedBy = "cancion")
	public Collection<Valoracion> valoraciones;
		
	@ManyToMany(mappedBy="songs")
	private Collection<Playlist> playlists;
	
	@ManyToOne
	private Album album;
	
	
	public void setIdCancion(Long idCancion)
	{
		this.idCancion=idCancion;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	
	public void setEstado(Boolean activo)
	{
		this.activo=activo;
	}
	public void setLetra(String letra)
	{
		this.letra=letra;
	}
	public void setFecha(Date fecha)
	{
		this.fecha=fecha;
	}
	public void setNumReproducciones(Integer numReproducciones)
	{
		this.numReproducciones=numReproducciones;
	}

	public void addValoracion(Valoracion valoracion)
	{
		this.valoraciones.add(valoracion);
	}
	
	
	
	public Long getIdCancion()
	{
		return idCancion;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	public boolean getEstado()
	{
		return activo;
	}
	
	public Date getFecha()
	{
		return fecha;
	}
	public Integer getNumReproducciones()
	{
		return numReproducciones;
	}
	
	/*public void obtener_info()
	{
		System.out.println("nombre de la cancion: "+m_nombre_cancion+"\n");
		System.out.println("letra de la cancion: "+get_letra_cancion()+"\n");
		System.out.println("fecha de lanzamiento: "+get_fecha_cancion()+"\n");
	}*/
	
	
	

}
