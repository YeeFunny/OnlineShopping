package com.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile ListAttribute<User, Address> addresses;
	public static volatile ListAttribute<User, Card> cards;
	public static volatile SingularAttribute<User, Gender> gender;
	public static volatile SingularAttribute<User, String> mobile;
	public static volatile ListAttribute<User, Order> orders;
	public static volatile ListAttribute<User, CartItem> cartItems;
	public static volatile SingularAttribute<User, Integer> userId;

	public static final String ADDRESSES = "addresses";
	public static final String CARDS = "cards";
	public static final String GENDER = "gender";
	public static final String MOBILE = "mobile";
	public static final String ORDERS = "orders";
	public static final String CART_ITEMS = "cartItems";
	public static final String USER_ID = "userId";

}

