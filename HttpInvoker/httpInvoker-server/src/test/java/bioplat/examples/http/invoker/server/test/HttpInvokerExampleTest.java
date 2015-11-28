package bioplat.examples.http.invoker.server.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bioplat.examples.http.invoker.common.services.IBioplatService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfigurer.class)
public class HttpInvokerExampleTest {

	@Autowired
	private IBioplatService bioplatService;  


	@Test
	public void testSimplePing() {
		bioplatService.ping();
	}

}
