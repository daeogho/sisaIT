package com.doldam.mini.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doldam.mini.service.LikeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LikeController {
	
	@Inject
	LikeService service;
	
	//좋아요 추가
	@PostMapping("season/updateLike")
	@ResponseBody
	public int updateLike(int no, HttpSession session) {
		String userID = (String)session.getAttribute("logId");
		//유효성 검사
		if(userID == null || userID.equals("")){
			 return -1;
		}
		
		if(userID == null) return -1;
		
		try {// 1. 이미 좋아요 눌렀는지 확인
			int check = service.likeCheck(no, userID);
			
			if(check>0) {// 2. 눌렀으면 DELETE,
				service.likeDelete(no, userID);
				return 0;
			}else {//3. 안 눌렀으면 INSERT 실행
				service.likeInsert(no, userID);
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return -2;
		}
	}
}
