package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.util.Date;

@Entity

public class Valoracion {
	@Id
	@SequenceGenerator(name = "album_id_generator", sequenceName = "album_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "album_id_generator")
	private Long id_valoración;
	
	@Column(nullable=false)
	private Integer puntuacion;
	
	@Column(nullable=false)
	private Long cont_reproducciones;
	
	@ManyToOne
	private Cancion cancion;
	
	public Integer getPuntuacion(){
		return puntuacion;
	}
	
	public void setPuntuacion(Integer puntuacion){
		this.puntuacion=puntuacion;
	}
	
	public Long getContReproducciones(){
		return cont_reproducciones;
	}
	
	public void setContReproducciones(Long cont_reproducciones){
		this.cont_reproducciones=cont_reproducciones;
	}
	
	public Cancion getCancion(){
		return cancion;
	}
	
	public void setCancion(Cancion cancion){
		this.cancion=cancion;
	}
}
