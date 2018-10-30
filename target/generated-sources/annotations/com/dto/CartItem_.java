package com.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CartItem.class)
public abstract class CartItem_ {

	public static volatile SingularAttribute<CartItem, Product> product;
	public static volatile SingularAttribute<CartItem, Integer> amount;
	public static volatile SingularAttribute<CartItem, User> user;
	public static volatile SingularAttribute<CartItem, Integer> cartItemId;

	public static final String PRODUCT = "product";
	public static final String AMOUNT = "amount";
	public static final String USER = "user";
	public static final String CART_ITEM_ID = "cartItemId";

}

