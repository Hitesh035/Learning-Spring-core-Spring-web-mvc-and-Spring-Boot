package com.hitesh.springwebv2.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ServletConfiguration implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
			
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(AppConfiguration.class);
		DispatcherServlet servlet = new DispatcherServlet(applicationContext);
		javax.servlet.ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", servlet);
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);
		
		
	}

}
