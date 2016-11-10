package app.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.util.Date;

@Entity

public class Album {
	@Id
	@SequenceGenerator(name = "album_id_generator", sequenceName = "album_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "album_id_generator")
	private Long id_album;
	
	@Column(length = 64)
	private String nombre;
	
	@Column(nullable=false)
	private boolean activo;
	
	@Column(nullable=false)
	private Date date;
	
	@ManyToOne
	private Artista sourceArtista;
	
	public String get_nombre(){
		return nombre;
	}
	
	public void set_activo(String nombre){
		this.nombre=nombre;
	}
	
	public boolean get_activo(){
		return activo;
	}
	
	public void set_activo(boolean activo){
		this.activo=activo;
	}
	
	public Date get_date(){
		return date;
	}
	
	public void setDate(Date date){
		this.date=date;
	}
	
	public Artista getSourceArtista(){
		return sourceArtista;
	}
	
	public void getSourceArtista(Artista sourceArtista){
		this.sourceArtista=sourceArtista;
	}
}
