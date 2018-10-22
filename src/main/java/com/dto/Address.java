package com.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESS_ID")
	private Integer addressId;
	@Column(name = "FULL_NAME", nullable = false)
	private String fullName;
	@Column(name = "STREET", nullable = false)
	private String street;
	@Column(name = "STREETTWO")
	private String streetTwo;
	@Column(name = "CITY", nullable = false)
	private String city;
	@Column(name = "STATE", nullable = false)
	private String state;
	@Column(name = "ZIP", nullable = false)
	private String zip;
	@Column(name = "COUNTRY", nullable = false)
	private String country;
	@ManyToMany
	@JoinTable(name = "USER_ADDRESS", joinColumns = { @JoinColumn(name = "ADDRESS_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "USER_ID") })
	private List<User> users;

}
