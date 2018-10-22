package com.service;

import org.springframework.stereotype.Service;

import com.dto.User;
import com.exception.DatabaseException;
import com.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Override
	public User getUserById(int id) {
		return userRepository.getUserById(id);
	}

	@Override
	public int addUser(User user) throws DatabaseException {
		return userRepository.addUser(user);
	}

	@Override
	public int updateUser(User user) throws DatabaseException {
		return userRepository.updateUser(user);
	}

}
