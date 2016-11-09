package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Administrador extends Persona {

		@Id
		@SequenceGenerator(name = "administrador_id_generator", sequenceName = "administrador_id_seq", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "administrador_id_generator")
		
		private Long id_administrador;
		
		public Long get_id_administrador(){
			return id_administrador;
		}
		
		public void set_id_administrador(Long id_administrador){
			this.id_administrador=id_administrador;
		}
		
}
