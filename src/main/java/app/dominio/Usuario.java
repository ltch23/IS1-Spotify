package app.dominio;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario {
//	enum TipoUsuario {
//		ADMIN, GENERAL
//	}

	@Id
	@SequenceGenerator(name = "usuario_id_generator", sequenceName = "usuario_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_generator")
	private Long idUsuario;
	
	@Column(length=64)
	public String nickname;
	
	@Column(length=64)
	public String contrasena;
		
	@Column(nullable=false)
	private Date fechaCreacion=new Date();
	
	@Column(nullable=false)
	private boolean activo;

	@OneToMany(mappedBy = "usuario")
	private Collection<Playlist> playlists;

	@OneToOne
	@JoinColumn(name = "personaId")
	private Persona persona;
	/*
	@OneToMany(mappedBy="Lista_de_canciones")
	Crear Clase Cancion
	private Collection<Cancion> timeline;
	*/
//	TipoUsuario tipo;

	public Long getIdUsuario(){
		return idUsuario;
	}
	
	public void setIdUsuario(Long idUsuario){
		this.idUsuario=idUsuario;
	}
	
	public String getNickname(){
		return nickname;
	}
		
	public void setNickname(String nickname){
		this.nickname=nickname;
	}
	
	/*
	public String get_contrasena(){
		return contrasena;
	}
		
	public void set_contrasena(String contrasena){
		this.contrasena=contrasena;
	}
	*/
	public Date getFechaCreacion(){
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion){
		this.fechaCreacion=fechaCreacion;
	}
	
	public boolean getActivo(){
		return activo;
	}
	
	public void setActivo(boolean activo){
		this.activo=activo;
	}

	public Collection<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Collection<Playlist> playlists) {
		this.playlists = playlists;
	}
	
	

}
