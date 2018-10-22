package com.service;

import com.dto.Login;
import com.exception.DatabaseException;


public interface LoginService {
	
	public Login getLogin(Login login);
	
	public Login addLogin(Login login) throws DatabaseException;
	
}
