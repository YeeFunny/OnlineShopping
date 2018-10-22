package com.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dto.Address;
import com.dto.Card;
import com.dto.CartItem;
import com.dto.Category;
import com.dto.Login;
import com.dto.Order;
import com.dto.Product;
import com.dto.Search;
import com.dto.User;

@Configuration
@EnableWebMvc
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

	@Bean("dataSource")
	@DependsOn("dbProperty")
	public DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(getUrl());
		ds.setPassword(getPassword());
		ds.setUsername(getUsername());
		ds.setDriverClassName(getDriverName());
		return ds;
	}

	@Bean
	@DependsOn("dbProperty")
	public SessionFactory getSessionFactory() {
		SessionFactory sf;
		org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration().addPackage("com.dto");
		cfg.addAnnotatedClass(Address.class).addAnnotatedClass(Card.class).addAnnotatedClass(User.class)
			.addAnnotatedClass(CartItem.class).addAnnotatedClass(Category.class).addAnnotatedClass(Login.class)
			.addAnnotatedClass(Order.class).addAnnotatedClass(Product.class).addAnnotatedClass(Search.class);
		cfg.setProperty(Environment.HBM2DDL_AUTO, getHbm2ddl());
		cfg.setProperty(Environment.DIALECT, getDialect());
		cfg.setProperty("hibernate.connection.username", getUsername());
		cfg.setProperty("hibernate.connection.password", getPassword());
		cfg.setProperty("hibernate.connection.driver_class", getDriverName());
		cfg.setProperty("hibernate.connection.url", getUrl());
		cfg.setProperty(Environment.SHOW_SQL, getShow_url());

		StandardServiceRegistryBuilder rb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		sf = cfg.buildSessionFactory(rb.build());
		return sf;
	}
}