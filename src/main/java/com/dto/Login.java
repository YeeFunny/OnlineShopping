package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Inheritance(strategy = InheritanceType.JOINED)
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LOGIN_ID")
	Integer loginId;
	@NotNull(groups = { LoginValidation.class, RegisterValidation.class }, message = "Email cannot be null")
	@Email(message = "Email is invalid")
	@Column(name = "EMAIL", unique = true, nullable = false)
	String email;
	@NotNull(groups = { RegisterValidation.class }, message = "Name cannot be null")
	@Size(groups = {
			RegisterValidation.class }, min = 2, max = 200, message = "Name must be between 2 and 200 characters")
	@Column(name = "NAME", nullable = false)
	String name;
	@NotNull(groups = { LoginValidation.class, RegisterValidation.class }, message = "Password cannot be null")
	@Size(groups = { LoginValidation.class,
			RegisterValidation.class }, min = 6, message = "Password must be more than 6 characters")
	@Column(name = "PASSWORD", nullable = false)
	String password;
	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE", nullable = false)
	UserRole role;

	public interface LoginValidation {
	}

	public interface RegisterValidation {
	}

}
