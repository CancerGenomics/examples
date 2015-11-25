package bioplat.examples.http.invoker.common.services;

import bioplat.examples.http.invoker.common.dto.SimpleDTO;

/**
 * Interfaz para el servicio de ejemplo de http invoker
 * @author hernan
 *
 */
public interface IBioplatService {
	
	void ping();
	
	String pingConRespuesta();
	
	SimpleDTO pingConRespuestaDTO();

}
