package bioplat.examples.http.invoker.server.service.impl;

import bioplat.examples.http.invoker.common.dto.SimpleDTO;
import bioplat.examples.http.invoker.common.services.IBioplatService;

public class BioplatServiceImpl implements IBioplatService {

	@Override
	public void ping() {
		System.out.println("OUCH");

	}

	@Override
	public String pingConRespuesta() {
		System.out.println("OUCH");
		return null;
	}

	@Override
	public SimpleDTO pingConRespuestaDTO() {
		System.out.println("OUCH");
		return null;
	}

}
