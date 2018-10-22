package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CARTITEM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CARTITEM_ID")
	private Integer cartItemId;
	@ManyToOne(optional = false)
	@JoinColumn(name = "USER_ID")
	private User user;
	@ManyToOne(optional = false)
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	@Column(name = "AMOUNT", nullable = false)
	private Integer amount;

}
