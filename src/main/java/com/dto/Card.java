package com.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARD")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CARD_ID")
	private Integer cardId;
	@Column(name = "FULL_NAME", nullable = false)
	private String fullName;
	@Column(name = "CARD_NUM", nullable = false, unique = true)
	private Integer cardNum;
	@Column(name = "EXPIRATION", nullable = false)
	private Date expiration;

	public Card() {
		super();
	}

	public Card(Integer cardId, String fullName, Integer cardNum, Date expiration) {
		super();
		this.cardId = cardId;
		this.fullName = fullName;
		this.cardNum = cardNum;
		this.expiration = expiration;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getCardNum() {
		return cardNum;
	}

	public void setCardNum(Integer cardNum) {
		this.cardNum = cardNum;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

}
