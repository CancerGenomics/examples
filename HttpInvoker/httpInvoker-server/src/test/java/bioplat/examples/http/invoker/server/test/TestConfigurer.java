package bioplat.examples.http.invoker.server.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import bioplat.examples.http.invoker.common.services.IBioplatService;

@ComponentScan(basePackages="bioplat.examples.http.invoker.server.test")
@EnableAutoConfiguration
public class TestConfigurer {

	@Bean 
	public HttpInvokerProxyFactoryBean createHttpInvokerProxyFactoryBean() {
		HttpInvokerProxyFactoryBean fb = new HttpInvokerProxyFactoryBean();
		fb.setServiceUrl("http://localhost:8080/bioplatRemote/PingService");
		fb.setServiceInterface(IBioplatService.class);
		return fb;
	}

}
