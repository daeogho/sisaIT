package com.doldam.mini.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.doldam.mini.dao.UserDAO;
import com.doldam.mini.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	UserDAO dao;

	@Override
	public int userInsert(UserDTO dto) {
		return dao.userInsert(dto);
	}

	@Override
	public UserDTO login(String userID, String userpwd) {
		return dao.login(userID, userpwd);
	}
	
}
