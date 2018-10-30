package com.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, String> zip;
	public static volatile SingularAttribute<Address, String> country;
	public static volatile SingularAttribute<Address, String> streetTwo;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, String> street;
	public static volatile SingularAttribute<Address, String> fullName;
	public static volatile SingularAttribute<Address, String> state;
	public static volatile ListAttribute<Address, User> users;
	public static volatile SingularAttribute<Address, Integer> addressId;

	public static final String ZIP = "zip";
	public static final String COUNTRY = "country";
	public static final String STREET_TWO = "streetTwo";
	public static final String CITY = "city";
	public static final String STREET = "street";
	public static final String FULL_NAME = "fullName";
	public static final String STATE = "state";
	public static final String USERS = "users";
	public static final String ADDRESS_ID = "addressId";

}

