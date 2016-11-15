package app.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Persona {

	@Id
	@SequenceGenerator(name = "persona_id_generator", sequenceName = "persona_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_id_generator")
	private Long idPersona;
	
	@Column(length = 64)
	private String nombre;
	
	@Column(nullable=false)
	private boolean sexo;
//
//	@ManyToMany
//	private Artista artista;

	@OneToOne
	@JoinColumn(name = "usuarioId")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name = "administradorId")
	private Administrador administrador;
	
	
	
	
	public Long getIdPersona(){
		return idPersona;
	}
	
	public void setIdPersona(Long idPersona){
		this.idPersona=idPersona;
	}
	
	public String getNombre(){
	return nombre;
	}
	
	public void setNombre(String nombre ){
		this.nombre=nombre;
	}
	
	public boolean getSexo(){
		return sexo;
	}
	
	public void setSexo(boolean sexo){
		this.sexo=sexo;
	}
	
	
	
	
}
