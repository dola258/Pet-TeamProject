package com.cos.petproject.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.petproject.domain.user.UserRepository;
import com.cos.petproject.handler.exception.MyAsyncNotFoundException;
import com.cos.petproject.util.MyAlgorithm;
import com.cos.petproject.util.SHA;
import com.cos.petproject.util.Script;
import com.cos.petproject.web.dto.user.JoinReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserRepository userRepository;
	private final HttpSession session;

	// 아이디 찾기 기능---------------------------------------
	@GetMapping("/id/modal")
	public @ResponseBody String idFind() {
		return "/";
	}
	
	// 비밀번호 변경 기능 ------------------------------------
	@GetMapping("/pw/modal")
	public @ResponseBody String pwFind() {
		return "/";
	}
	@PutMapping("/pw/change")
	public @ResponseBody String pwChange() {
		return "/";
	}

	// 로그인 기능--------------------------------------------
	@PostMapping("/login")
	public @ResponseBody String login() {

		return "/";
	}

	// 회원가입 기능 --------------------------------------------
	@PostMapping("/join")
	public @ResponseBody String join() {
		
		return "/";
	}

	// 회원정보 수정 기능-------------------------------------------
	@PutMapping("/user/{id}")
	public @ResponseBody String update() {
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

	@GetMapping("/user/detail/{id}")
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

	@GetMapping("/admin/home")
	public String adminHome() {

		return "admin/home";
	}
}
