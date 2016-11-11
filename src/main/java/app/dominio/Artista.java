package app.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Artista {

		@Id
		@SequenceGenerator(name = "artista_id_generator", sequenceName = "artista_id_seq", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artista_id_generator")
		private Long idArtista;
		
//      Artista compuesto por uno o muchas personas
//		@OneToMany(mappedBy="Personas")
//		private Collection<Persona> artistas;
		
		
		@Column(length = 64)
		private String nombre;
		
		@Column(nullable=false)
		private Date fecha=new Date();
		
		@Column(nullable=false)
		private boolean activo;
		
		//get y set de personas
//		public Collection<Persona> get_artistas(){
//			return artistas;
//		}
//		
//		public void set_artistas (Collection<Persona> artistas){
//			this.artistas=artistas;
//		}
		
		
		public String getNombre(){
		return nombre;
		}
		
		public void setNombreArtita(String nombre){
			this.nombre=nombre;
		}
		
		public Date getFecha(){
			return fecha;
		}
		
		public void setFecha(Date fecha){
			this.fecha=fecha;
		}
		
		public boolean getActivo(){
			return activo;
		}
		
		public void setActivo(boolean activo){
			this.activo=activo;
		}
		
}
