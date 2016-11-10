package dominio;

import java.sql.Date;
import java.util.Collection;
import java.util.Date;

<<<<<<< HEAD
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
>>>>>>> 906c8dd5e16e5c94c4c1378adff8cd51f8aa7c49
public class Cancion {
	@Id
	@SequenceGenerator(name = "cancion_id_generator", sequenceName = "cancion_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancion_id_generator")
	
	private Long m_idcancion;
	
	public String m_nombre_cancion;
	
	private boolean m_activo;
	
	private String m_letra;
	
	private Date m_fecha;
	
	private Integer m_numreproducciones;
	public Collection<Integer> m_valoraciones;
	
	
	public void set_id_cancion(Long id_cancion)
	{
		m_idcancion=id_cancion;
	}
	public void set_estado_cancion(Boolean estado)
	{
		m_activo=estado;
	}
	public void set_letra_cancion(String letra)
	{
		m_letra=letra;
	}
	public void set_fecha_cancion(Date fecha)
	{
		m_fecha=fecha;
	}
	public void set_numreproducciones(Integer numreproducciones)
	{
		m_numreproducciones=numreproducciones;
	}

	public void add_valoracion(Integer valoracion)
	{
		m_valoraciones.add(valoracion);
	}
	
	
	
	public Long get_id_cancion()
	{
		return m_idcancion;
	}
	public boolean get_estado_cancion()
	{
		return m_activo;
	}
	public String get_letra_cancion()
	{
		return m_letra;
	}
	public Date get_fecha_cancion()
	{
		return m_fecha;
	}
	public Integer get_numreproducciones()
	{
		return m_numreproducciones;
	}
	
	public void obtener_info()
	{
		System.out.println("nombre de la cancion: "+m_nombre_cancion+"\n");
		System.out.println("letra de la cancion: "+get_letra_cancion()+"\n");
		System.out.println("fecha de lanzamiento: "+get_fecha_cancion()+"\n");
	}
	
	
	

}