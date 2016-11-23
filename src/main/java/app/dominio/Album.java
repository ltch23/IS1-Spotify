package app.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.util.List;
import java.util.Date;

@Entity

public class Album {
	@Id
	@SequenceGenerator(name = "album_id_generator", sequenceName = "album_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "album_id_generator")
	private Long idAlbum;
	
	@Column(length = 64)
	private String nombre;
	
	@Column(nullable=false)
	private boolean activo=true;
	
	@Column(nullable=false)
	private Date fecha=new Date();
	
	@ManyToOne()
	private Artista artista;
		
	
	@OneToMany(mappedBy = "album")
	public List<Cancion> canciones;
	
	public Long getId(){
		return idAlbum;
	}
	
	public void setID(Long idAlbum){
		this.idAlbum=idAlbum;
	}
	
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public boolean getEstado(){
		return activo;
	}
	
	public void setEstado(boolean activo){
		this.activo=activo;
	}
	
	public Date getFecha(){
		return fecha;
	}
	
	public void setFecha(Date fecha){
		this.fecha=fecha;
	}
	
	public Artista getArtista(){
		return artista;
	}
	
	public void setArtista(Artista artista){
		this.artista=artista;
	}
}
