package com.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(new Class[] { RootConfig.class });
		rootContext.setServletContext(servletContext);
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		Dynamic servletOne = servletContext.addServlet("myServlet", new DispatcherServlet());
		servletOne.addMapping("/");
		servletOne.setAsyncSupported(true);
		servletOne.setInitParameter("contextConfigLocation", "com.config.SpringConfig");
		servletOne.setInitParameter("contextClass",
				"org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
		servletOne.setLoadOnStartup(1);
	}

}
