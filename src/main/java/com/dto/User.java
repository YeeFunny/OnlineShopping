package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "user")
@Table(name = "SHOPPING_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@PrimaryKeyJoinColumn(name = "USER_ID")
public class User extends Login{
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String mobile;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "USER_ID")
	private List<Card> cards = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "USER_ID")
	private List<CartItem> cartItems = new ArrayList<>();

}
