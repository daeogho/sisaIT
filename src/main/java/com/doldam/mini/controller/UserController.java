package com.doldam.mini.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doldam.mini.dto.UserDTO;
import com.doldam.mini.service.UserService;



@Controller
public class UserController {
	@Autowired
	UserService service;
	

	// 회원가입 폼
	@GetMapping("/users/userForm")
	public String userForm() {
			return "users/userForm";
	}
	// 회원가입(DB)
	@PostMapping("/users/userFormOk")
	public String userFormOk(UserDTO dto, Model model) {
		// int result = service.usersInsert(dto);
		//  model.addAttribute("result", result);
		model.addAttribute("result", service.userInsert(dto));
			 
		return "home";
	}
	// 로그인 폼
	@GetMapping("/users/login")
	public String login() {
			return "users/login";
	}
	 // 로그인(DB조회)
	 @RequestMapping(value="/users/loginOk", method=RequestMethod.POST)
	 public ModelAndView loginOk(String userID, String userpwd, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		 //아이디와 이름 들어가있음
		UserDTO dto = service.login(userID, userpwd);
		// 로그인 성공 - 로그인 정보를 session에 기록 - 홈페이지
		if(dto != null) {
			session.setAttribute("logId", dto.getUserID());
			session.setAttribute("logName", dto.getUsername());
			
			System.out.println("세션 저장 logId = " + dto.getUserID());
			
			
			mav.setViewName("redirect:/");  //현재 컨트롤러 매핑 -> 다른 매핑주소 바로 호출
		}else{// 로그인 실패 - 로그인 폼으로
			mav.setViewName("redirect:login");
		}
		return mav;
	 }
	// 로그아웃
	@GetMapping("/users/logout")
	public ModelAndView logout(HttpSession session) {
			session.invalidate();
			 
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/");
			 
			 return mav;
	}
		
}
