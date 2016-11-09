package dominio;

import java.util.Collection;
import java.util.Date;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Artista {

		@Id
		@SequenceGenerator(name = "artista_id_generator", sequenceName = "artista_id_seq", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artista_id_generator")
		private Long id_artista;
		
				//Artista compuesto por uno o muchas personas
		@OneToMany(mappedBy="Personas")
		private Collection<Persona> artistas;
		
		
		@Column(length = 64)
		private String nombre_artista;
		
		@Column(nullable=false)
		private Date fecha_creacion=new Date();
		
		@Column(nullable=false)
		private boolean activo;
		
		//get y set de personas
		public Collection<Persona> get_artistas(){
			return artistas;
		}
		
		public void set_artistas (Collection<Persona> artistas){
			this.artistas=artistas;
		}
		
		
		public String get_nombre_artista(){
		return nombre_artista;
		}
		
		public void set_nombre_artita(String nombre_artista ){
			this.nombre_artista=nombre_artista;
		}
		
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
