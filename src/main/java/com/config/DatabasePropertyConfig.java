package com.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableTransactionManagement(proxyTargetClass=false)
public class DatabasePropertyConfig {

	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("${jdbc.driverName}")
	private String driverName;
	@Value("${jdbc.hbm2ddl.auto}")
	private String hbm2ddl;
	@Value("${jdbc.dialect}")
	private String dialect;
	@Value("${jdbc.show_url}")
	private String show_url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getHbm2ddl() {
		return hbm2ddl;
	}

	public void setHbm2ddl(String hbm2ddl) {
		this.hbm2ddl = hbm2ddl;
	}

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	public String getShow_url() {
		return show_url;
	}

	public void setShow_url(String show_url) {
		this.show_url = show_url;
	}

//	@Bean("dataSource")
//	@DependsOn("dbProperty")
//	public DataSource getDataSource() {
//		BasicDataSource ds = new BasicDataSource();
//		ds.setUrl(getUrl());
//		ds.setPassword(getPassword());
//		ds.setUsername(getUsername());
//		ds.setDriverClassName(getDriverName());
//		return ds;
//	}

	@Bean
	@DependsOn("dbProperty")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(getUrl());
		ds.setPassword(getPassword());
		ds.setUsername(getUsername());
		ds.setDriverClassName(getDriverName());
		return ds;
	}

//	@Bean
//	@DependsOn("dbProperty")
//	public SessionFactory getSessionFactory() {
//		SessionFactory sf;
//		org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration().addPackage("com.dto");
//		cfg.addAnnotatedClass(Address.class).addAnnotatedClass(Card.class).addAnnotatedClass(User.class)
//				.addAnnotatedClass(CartItem.class).addAnnotatedClass(Category.class).addAnnotatedClass(Login.class)
//				.addAnnotatedClass(Order.class).addAnnotatedClass(Product.class).addAnnotatedClass(Search.class);
//		cfg.setProperty(Environment.HBM2DDL_AUTO, getHbm2ddl());
//		cfg.setProperty(Environment.DIALECT, getDialect());
//		cfg.setProperty("hibernate.connection.username", getUsername());
//		cfg.setProperty("hibernate.connection.password", getPassword());
//		cfg.setProperty("hibernate.connection.driver_class", getDriverName());
//		cfg.setProperty("hibernate.connection.url", getUrl());
//		cfg.setProperty(Environment.SHOW_SQL, getShow_url());
//
//		StandardServiceRegistryBuilder rb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
//		sf = cfg.buildSessionFactory(rb.build());
//		return sf;
//	}

	@Bean
	public Properties getProperties() {
		Properties properties = new Properties();
		properties.put(Environment.SHOW_SQL, getShow_url());
		properties.put(Environment.HBM2DDL_AUTO, getHbm2ddl());
		properties.put(Environment.DIALECT, getDialect());
		return properties;
	}

	@Bean("getSessionFactory")
	public SessionFactory getSessionFactory() throws IOException {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(getDataSource());
		bean.setHibernateProperties(getProperties());
		bean.setPackagesToScan("com.dto");
		bean.afterPropertiesSet();
		return bean.getObject();
	}
	
	@Bean
	public HibernateTemplate template() throws IOException {
		HibernateTemplate template= new HibernateTemplate();
		template.setSessionFactory(getSessionFactory());
		return template;
	}
	
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager() throws IOException {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(getSessionFactory());
		return htm;
	}
}