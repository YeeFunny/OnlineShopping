package com.dto;

import java.sql.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "order")
@Table(name = "SHOPPING_ORDER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private Integer orderId;
	@ManyToOne(optional = false)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;
	@ManyToOne(optional = false)
	@JoinColumn(name = "ADDRESS_ID", nullable = false)
	private Address address;
	@ManyToOne(optional = false)
	@JoinColumn(name = "CARD_ID", nullable = false)
	private Card card;
//	@ElementCollection
	@ManyToMany
//	@MapKeyClass(value = Product.class)
	private Map<Product, Integer> productList;
	@Column(name = "ORDER_TIME")
	private Date orderTime;
	private Integer amount;
	private Date expectedDelivery;
	private Integer status;

}
