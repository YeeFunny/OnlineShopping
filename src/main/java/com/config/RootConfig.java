package com.config;

import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableWebMvc
@Import(DatabasePropertyConfig.class)
public class RootConfig implements WebMvcConfigurer {

	@Autowired
	DataSource ds;

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

	@Bean("localeChangeInterceptor")
	public LocaleChangeInterceptor getLocaleChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("language");
		return interceptor;
	}

	@Bean("localeResolver")
	public LocaleResolver getLocaleResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.ENGLISH);
		return resolver;
	}

	@Bean("messageSource")
	public ResourceBundleMessageSource getMessageSource() {
		ResourceBundleMessageSource src = new ResourceBundleMessageSource();
		src.addBasenames("locale/locale");
		src.setDefaultEncoding("UTF-8");
		return src;
	}

	@Bean("dbProperty")
	public static PropertySourcesPlaceholderConfigurer getDatabasePropertry() {
		PropertySourcesPlaceholderConfigurer pc = new PropertySourcesPlaceholderConfigurer();
		pc.setLocation(new ClassPathResource("database.properties"));
		return pc;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getLocaleChangeInterceptor());
	}
}
