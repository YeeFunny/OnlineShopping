package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Login;
import com.exception.DatabaseException;
import com.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Login getLogin(Login login) {
		return loginRepository.getLogin(login);
	}

	@Override
	public Login addLogin(Login login) throws DatabaseException {
		return loginRepository.addLogin(login);
	}

}
