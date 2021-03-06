package com.dto;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Card.class)
public abstract class Card_ {

	public static volatile SingularAttribute<Card, String> cardNum;
	public static volatile SingularAttribute<Card, Integer> cvv;
	public static volatile SingularAttribute<Card, String> cardName;
	public static volatile SingularAttribute<Card, Integer> cardId;
	public static volatile SingularAttribute<Card, Date> expiration;
	public static volatile SingularAttribute<Card, User> user;

	public static final String CARD_NUM = "cardNum";
	public static final String CVV = "cvv";
	public static final String CARD_NAME = "cardName";
	public static final String CARD_ID = "cardId";
	public static final String EXPIRATION = "expiration";
	public static final String USER = "user";

}

