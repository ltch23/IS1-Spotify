package app.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity

public class Valoracion {
	@Id
	@SequenceGenerator(name = "valoracion_id_generator", sequenceName = "valoracion_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "valoracion_id_generator")
	private Long idValoracion;
<<<<<<< HEAD
	
	@Column(nullable=false)
	private Long idUsuario;
=======
>>>>>>> 1f189404a5c1a504f9b909d5809bad445ee3ed74
	
	@ManyToOne
	private Cancion cancion;
	
	@Column(nullable=false)
	private Integer puntuacion;
	
	
	/*@Column(nullable=false)
	private Long cont_reproducciones;*/

	
	public Integer getPuntuacion(){
		return puntuacion;
	}
	
	public void setPuntuacion(Integer puntuacion){
		this.puntuacion=puntuacion;
	}
	
	/*public Long getContReproducciones(){
		return cont_reproducciones;
	}
	
	public void setContReproducciones(Long cont_reproducciones){
		this.cont_reproducciones=cont_reproducciones;
	}*/
	
	public Cancion getCancion(){
		return cancion;
	}
	
	public Long getIdValoracion(){
		return idValoracion;
	}
	
	
	public Long getIdCancion(Cancion song){
		return song.getIdCancion();
	}
	
	public void setCancion(Cancion cancion){
		this.cancion=cancion;
	}
}
