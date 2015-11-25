package bioplat.examples.http.invoker.common.dto;

import java.util.Date;

/**
 * Clase DTO simple para pasar como parámetro en el ejemplo de http invoker
 * 
 * @author hernan
 *
 */
public class SimpleDTO {

	private long id;

	private String nombre;

	private Date fecha;

	public SimpleDTO(long id, String nombre, Date fecha) {
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
