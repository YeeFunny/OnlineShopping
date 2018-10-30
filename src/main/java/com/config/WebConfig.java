package com.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.filter.CheckOutFilter;

public class WebConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.setServletContext(servletContext);
		ctx.register(RootConfig.class);
		servletContext.addListener(new ContextLoaderListener(ctx));
		
		Dynamic servlet = servletContext.addServlet("myServlet", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	
		FilterRegistration.Dynamic filter = servletContext.addFilter("checkOutFilter"
				, CheckOutFilter.class);
		filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/checkoutPage");
		
//		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//		rootContext.register(new Class[] { RootConfig.class });
//		rootContext.setServletContext(servletContext);
//		servletContext.addListener(new ContextLoaderListener(rootContext));
//		
//		Dynamic servletOne = servletContext.addServlet("myServlet", new DispatcherServlet());
//		servletOne.addMapping("/");
//		servletOne.setAsyncSupported(true);
//		servletOne.setInitParameter("contextConfigLocation", "com.config.SpringConfig");
//		servletOne.setInitParameter("contextClass",
//				"org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
//		servletOne.setLoadOnStartup(1);
//		
//		FilterRegistration.Dynamic checkOutFilter = servletContext.addFilter("checkOutFilter", 
//				CheckOutFilter.class);
//		checkOutFilter.addMappingForUrlPatterns(null, false, "/checkout");
	}

}
