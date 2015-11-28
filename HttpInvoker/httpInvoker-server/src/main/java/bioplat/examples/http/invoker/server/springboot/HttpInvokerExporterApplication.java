/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bioplat.examples.http.invoker.server.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import bioplat.examples.http.invoker.common.services.IBioplatService;
import bioplat.examples.http.invoker.server.service.impl.BioplatServiceImpl;

@ComponentScan(basePackages="bioplat.examples.http.invoker.server")
@EnableAutoConfiguration
public class HttpInvokerExporterApplication extends SpringBootServletInitializer{
	
	@Autowired
	private IBioplatService pingService;

	@Bean
	public ServletRegistrationBean dispatcherServletRegistration() {
//		HttpInvokerServlet ds = new HttpInvokerServlet();
		DispatcherServlet ds = new DispatcherServlet();
		AnnotationConfigWebApplicationContext appCtx = new AnnotationConfigWebApplicationContext();
		ds.setApplicationContext(appCtx);
		ServletRegistrationBean registration = new ServletRegistrationBean(ds, "/bioplatRemote/*");
		registration.setName("bioplatRemoteRegistration");
		return registration;
	}
	
	

	@Bean(name = "pingServiceBean")
	public IBioplatService getBioplatService(){
		return new BioplatServiceImpl();
	}
	
	@Bean(name="/PingService")
	public HttpInvokerServiceExporter getPingHttpInvokerServiceExporter() {
		HttpInvokerServiceExporter httpISE = new HttpInvokerServiceExporter();
		httpISE.setService(pingService);
		httpISE.setServiceInterface(IBioplatService.class);
		return httpISE;

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HttpInvokerExporterApplication.class, args);
	}

}
