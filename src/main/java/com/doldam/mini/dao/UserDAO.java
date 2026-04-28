package com.doldam.mini.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.doldam.mini.dto.UserDTO;

@Mapper
@Repository
public interface UserDAO {
	//회원등록
	public int userInsert(UserDTO dto);
	// 로그인
	public UserDTO login(String userID, String userpwd);
}
