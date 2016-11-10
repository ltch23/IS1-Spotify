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
	private Long id_playlist;

	@ManyToOne(targetEntity = Usuario.class)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Column(length = 64)
	public String nombre;
	
//	@Column(length = 64)
//	public Usuario user;
	
	@Column(length = 64)
	public Boolean activo;
	
	@Column(length = 64)
	public Date fecha;	
	
	@ManyToMany
	@JoinTable(name="playlist_has_songs", joinColumns={@JoinColumn(name="playlist_id")},inverseJoinColumns={@JoinColumn(name="cancion_id")})
	private Collection<Cancion> songs;
	
	public void agregar_cancion(Cancion cancion_1){
		
	}
	
	public void eliminar_cancion(Cancion cancion_1){
		
	}
	
	public void change_name(String namePlaylist){
		nombre = namePlaylist;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
