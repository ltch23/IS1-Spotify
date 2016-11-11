package app.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import app.dominio.Persona;


@Entity
public class Administrador {

		@Id
		@SequenceGenerator(name = "administrador_id_generator", sequenceName = "administrador_id_seq", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "administrador_id_generator")
		
		private Long idAdministrador;

		public Long getIdAdministrador() {
			return idAdministrador;
		}
		
		@OneToOne
		@JoinColumn(name = "persona_id")
		private Persona persona;
		
		
		public void setIdAdministrador(Long idAdministrador) {
			this.idAdministrador = idAdministrador;
		}
		
		
}
