package com.config;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.CacheControl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
@EnableWebMvc
@Import(DatabasePropertyConfig.class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = {"com.controller", "com.dto", "com.repository", "com.service", "com.filter"})
public class RootConfig implements WebMvcConfigurer {

	@Autowired
	DataSource ds;
	
	@Bean
	public HandlerMapping getHandler() {
		BeanNameUrlHandlerMapping handler= new BeanNameUrlHandlerMapping();
		return handler;
	}

	@Bean("localeChangeInterceptor")
	public LocaleChangeInterceptor getLocaleChangeInterceptor() {
		LocaleChangeInterceptor interceptor= new LocaleChangeInterceptor();
		interceptor.setParamName("language");
		return interceptor;
	}
	
	@Bean("localeResolver")
	public LocaleResolver getLocaleResolver() {
		SessionLocaleResolver resolver= new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.ENGLISH);
		return resolver;
	}
	
	@Bean("messageSource")
	public ResourceBundleMessageSource getMessageSource() {
		ResourceBundleMessageSource src= new ResourceBundleMessageSource();
		src.addBasenames("locale/locale");
		src.setDefaultEncoding("UTF-8");
		return src;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getLocaleChangeInterceptor());
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/")
			.setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
			.resourceChain(false)
			.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
		registry.addResourceHandler("/js/**").addResourceLocations("/js/")
			.setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
			.resourceChain(false)
			.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
		registry.addResourceHandler("/images/**").addResourceLocations("/images/")
			.setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
			.resourceChain(false)
			.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "indexList");
		registry.addRedirectViewController("/index", "indexList");
		registry.addRedirectViewController("/loginPage", "login");
		registry.addRedirectViewController("/registerPage", "register");
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate template = new JdbcTemplate(ds);
		return template;
	}

	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(ds);
		return template;
	}

	@Profile("dev")
	@Bean("dbProperty")
	public static PropertySourcesPlaceholderConfigurer getDevDatabasePropertry() {
		PropertySourcesPlaceholderConfigurer pc = new PropertySourcesPlaceholderConfigurer();
		pc.setLocation(new ClassPathResource("database-dev.properties"));
		return pc;
	}
	
	@Profile("pro")
	@Bean("dbProperty")
	public static PropertySourcesPlaceholderConfigurer getProDatabasePropertry() {
		PropertySourcesPlaceholderConfigurer pc = new PropertySourcesPlaceholderConfigurer();
		pc.setLocation(new ClassPathResource("database-pro.properties"));
		return pc;
	}
	
	@Profile("test")
	@Bean("dbProperty")
	public static PropertySourcesPlaceholderConfigurer getTestDatabasePropertry() {
		PropertySourcesPlaceholderConfigurer pc = new PropertySourcesPlaceholderConfigurer();
		pc.setLocation(new ClassPathResource("database-test.properties"));
		return pc;
	}

}
