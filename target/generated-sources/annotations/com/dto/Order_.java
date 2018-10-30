package com.dto;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Integer> amount;
	public static volatile SingularAttribute<Order, Address> address;
	public static volatile SingularAttribute<Order, Date> orderTime;
	public static volatile SingularAttribute<Order, Integer> orderId;
	public static volatile SingularAttribute<Order, User> user;
	public static volatile SingularAttribute<Order, Card> card;
	public static volatile MapAttribute<Order, Product, Integer> products;
	public static volatile SingularAttribute<Order, OrderStatus> status;

	public static final String AMOUNT = "amount";
	public static final String ADDRESS = "address";
	public static final String ORDER_TIME = "orderTime";
	public static final String ORDER_ID = "orderId";
	public static final String USER = "user";
	public static final String CARD = "card";
	public static final String PRODUCTS = "products";
	public static final String STATUS = "status";

}

