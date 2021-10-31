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
	
	
	// 아이디 찾기 기능---------------------------------------
	@GetMapping("/idFind")
	public String idFind() {
		return "/";
	}
	
	// 비밀번호 변경 기능 ------------------------------------
	@PutMapping("/pwChange")
	public String pwChange() {
		return "/";
	}
	
	
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

	@GetMapping("user/loginForm")
	public String userLoginForm() {
		
		return "user/loginForm";
	}

	@GetMapping("/user/joinForm")
	public String userJoinForm() {
		
		return "user/joinForm";
	}
	
	@GetMapping("/user/updateForm")
	public String userUpdateForm() {
		
		return "user/updateForm";
	}

	@GetMapping("/user/detail")
	public String userDetail() {
		
		return "user/detail";
	}
	
	@GetMapping("/user/idFind")
	public String userIdFind() {
		
		return "user/idFind";
	}
	
	@GetMapping("/user/pwfind")
	public String userPwFind() {
		
		return "user/pwFind";
	}
}
