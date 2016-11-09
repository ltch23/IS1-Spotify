package dominio;

import java.awt.List;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario extends Persona{
	@Id
	@SequenceGenerator(name = "usuario_id_generator", sequenceName = "usuario_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_generator")
	private Long id_usuario;
	
	@Column(length=64)
	public String nickname;
	
	@Column(length=64)
	public String contrasena;
		
	@Column(nullable=false)
	private Date fecha_creacion=new Date();
	
	@Column(nullable=false)
	private boolean activo;
	
	/*
	@OneToMany(mappedBy="Lista_de_canciones")
	Crear Clase Cancion
	private Collection<Cancion> timeline;
	*/
	
	public Long get_id_usuario(){
		return id_usuario;
	}
	
	public void set_id_usuario(Long id_usuario){
		this.id_usuario=id_usuario;
	}
	
	public String get_nickname(){
		return nickname;
	}
		
	public void set_nickname(String nickname){
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
	public Date get_fecha_creacion(){
		return fecha_creacion;
	}
	
	public void set_fecha_creacion(Date fecha_creacion){
		this.fecha_creacion=fecha_creacion;
	}
	
	public boolean get_activo(){
		return activo;
	}
	
	public void set_activo(boolean activo){
		this.activo=activo;
	}
	
	

}
