package com.repository;

import com.dto.Login;
import com.exception.DatabaseException;

public interface LoginRepository {
	
	public boolean emailExist(Login login);

	public Login getLogin(Login login);

	public Login addLogin(Login login) throws DatabaseException;
}
