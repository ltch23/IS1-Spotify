package app.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.util.Collection;
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
	private boolean activo;
	
	@Column(nullable=false)
	private Date date;
	
	@ManyToOne
	private Artista artista;
		
	
	@OneToMany(mappedBy = "album")
	public Collection<Cancion> canciones;
	
	public String get_nombre(){
		return nombre;
	}
	
	public void setActivo(String nombre){
		this.nombre=nombre;
	}
	
	public boolean getActivo(){
		return activo;
	}
	
	public void setActivo(boolean activo){
		this.activo=activo;
	}
	
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date=date;
	}
	
	public Artista getSourceArtista(){
		return artista;
	}
	
	public void getSourceArtista(Artista artista){
		this.artista=artista;
	}
}
