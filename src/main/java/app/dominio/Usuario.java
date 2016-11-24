package app.dominio;

import java.util.List;
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

	@Id
	@SequenceGenerator(name = "usuario_id_generator", sequenceName = "usuario_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_generator")
	private Long idUsuario;
	
	@Column(length=64)
	public String nickname;
	
	@Column(length=64)
	public String contrasena;
		
	@Column()
	private Date fecha=new Date();
	
	@Column()
	private boolean activo=true;

	@OneToMany(mappedBy = "usuario")
	private List<Playlist> playlists;

	@OneToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;

	public Long getIdUsuario(){
		return idUsuario;
	}
	
	public void sestIdUsuario(Long id_usuario){
		this.idUsuario=id_usuario;
	}
	
	public String getNickname(){
		return nickname;
	}
		
	public void setNickname(String nickname){
		this.nickname=nickname;
	}
	
	
	public Date getFecha(){
		return fecha;
	}
	
	public void setFecha(Date fecha){
		this.fecha=fecha;
	}
	
	public boolean getEstado(){
		return activo;
	}
	
	public void setEstado(boolean activo){
		this.activo=activo;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
	
	

}
