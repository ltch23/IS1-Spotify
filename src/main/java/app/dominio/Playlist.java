package app.dominio;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Playlist {
	@Id
	@SequenceGenerator(name = "playlist_id_generator", sequenceName = "playlist_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playlist_id_generator")
	private Long idPlaylist;

	@ManyToOne(targetEntity = Usuario.class)
	@JoinColumn(name = "usuarioId")
	private Usuario usuario;
	
	@Column(length = 64)
	public String nombre;
	
	@Column(length = 64)
	public Boolean activo;
	
	@Column(length = 64)
	public Date fecha;	
	
	public Long getIdPlaylist(){
		return idPlaylist;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public Boolean getEstado(){
		return activo;
	}
	
	public Date getFecha(){
		return fecha;
	}
	
	public void setIdPlaylist(Long idPlaylist){
		this.idPlaylist=idPlaylist;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setEstado(Boolean activo){
		this.activo=activo;
	}
	
	public void setFecha(Date fecha){
		this.fecha=fecha;
	}
	
	@ManyToMany
	@JoinTable(name="playlistHasSongs", joinColumns={@JoinColumn(name="playlistId")},inverseJoinColumns={@JoinColumn(name="cancionId")})
	private Collection<Cancion> songs;
		
	
	public void agregarCancion(Cancion cancion1){
		
	}
	
	public void eliminarCancion(Cancion cancion1){
		
	}
	
	public void changeName(String namePlaylist){
		nombre = namePlaylist;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
