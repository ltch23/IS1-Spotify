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
	private Long id_persona;
	
	@Column(length = 64)
	private String nombre;
	
	@Column(nullable=false)
	private boolean sexo;
//
//	@ManyToMany
//	private Artista artista;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name = "administrador_id")
	private Administrador administrador;
	
	
	
	
	public Long getIdPersona(){
		return id_persona;
	}
	
	public void setIdPersona(Long id_persona){
		this.id_persona=id_persona;
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
