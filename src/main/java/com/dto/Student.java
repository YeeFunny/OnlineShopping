package com.dto;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private int id;
	private String name;
	private String password; 
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}
}
