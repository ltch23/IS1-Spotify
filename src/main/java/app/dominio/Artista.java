package app.dominio;

import java.util.List;
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
		
		
		@OneToMany(mappedBy = "artista")
		public List<Album> albums;
		
		
		public List<Album> getAlbum(){
		return albums;
		}
		
		public void setAlbum (Album album){
			this.albums.add(album);
		}
		
		public String getNombre(){
		return nombre;
		}
		
		public void setNombre(String nombre){
			this.nombre=nombre;
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
		
}
