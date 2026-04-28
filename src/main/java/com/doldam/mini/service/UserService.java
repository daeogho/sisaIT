package com.doldam.mini.service;

import com.doldam.mini.dto.UserDTO;

public interface UserService {
	//회원등록
	public int userInsert(UserDTO dto);
	// 로그인
	public UserDTO login(String userID, String userpwd);
}
