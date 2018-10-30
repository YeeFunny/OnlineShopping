package com.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Login.class)
public abstract class Login_ {

	public static volatile SingularAttribute<Login, String> password;
	public static volatile SingularAttribute<Login, Integer> loginId;
	public static volatile SingularAttribute<Login, UserRole> role;
	public static volatile SingularAttribute<Login, String> name;
	public static volatile SingularAttribute<Login, User> user;
	public static volatile SingularAttribute<Login, String> email;

	public static final String PASSWORD = "password";
	public static final String LOGIN_ID = "loginId";
	public static final String ROLE = "role";
	public static final String NAME = "name";
	public static final String USER = "user";
	public static final String EMAIL = "email";

}

