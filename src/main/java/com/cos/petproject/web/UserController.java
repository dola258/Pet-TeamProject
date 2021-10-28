package com.cos.petproject.web;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cos.petproject.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Controller
public class UserController {
	
	private final UserRepository userRepository;
	private final HttpSession session;
	
	
	// 로그인 기능--------------------------------------------
	@PostMapping("/login")
	public String login() {
		return "/";
	}
	
	
	// 회원가입 기능 --------------------------------------------
	@PostMapping("/join")
	public String join() {
		return "/user/loginForm";
	}
	
	
	// 회원정보 수정 기능-------------------------------------------
	@PutMapping("/user/{id}")
	public String update() {
		return "/user/detail";
	}
	
	
	// 유저 관련 페이지 불러오기(GetMapping)
	@GetMapping("/logout")
	public String logout() {
		session.invalidate(); 
		return "/"; 
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		
		return "user/loginForm";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		
		return "user/joinForm";
	}

	@GetMapping("/detail")
	public String detail() {
		
		return "user/detail";
	}
	
	@GetMapping("/idfind")
	public String idFind() {
		
		return "user/id_find";
	}
	
	@GetMapping("/pwfind")
	public String pwFind() {
		
		return "user/pw_find";
	}
}
