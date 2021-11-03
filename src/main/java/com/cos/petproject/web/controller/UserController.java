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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.petproject.domain.authMail.AuthEmailRepository;
import com.cos.petproject.domain.user.User;
import com.cos.petproject.domain.user.UserRepository;
import com.cos.petproject.util.MyAlgorithm;
import com.cos.petproject.util.SHA;
import com.cos.petproject.util.Script;
import com.cos.petproject.web.dto.CMRespDto;
import com.cos.petproject.web.dto.user.ChangePwDto;
import com.cos.petproject.web.dto.user.FindPwReqDto;
import com.cos.petproject.web.dto.user.JoinReqDto;
import com.cos.petproject.web.dto.user.LoginReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserRepository userRepository;
	private final HttpSession session;
	private final AuthEmailRepository authEmailRepository;
	
	private int userId;
	
	
	// 아이디 찾기 기능---------------------------------------
	@GetMapping("/id/modal")
	public @ResponseBody String idFind() {
		return "/";
	}
	
	// 비밀번호 변경 기능 ------------------------------------
	@PostMapping("/pw/modal")
	public @ResponseBody CMRespDto<String> pwFind(@RequestBody @Valid FindPwReqDto dto) {
		User userEntity = userRepository.mPWFind(dto.getUsername(), dto.getName(),dto.getBirth(),dto.getEmail());
		userId = userEntity.getId();
	
		if(userEntity == null ) {
			return new CMRespDto<>(0, "존재하지 않는 회원입니다", null);
		} else {
			return new CMRespDto<>(1, "성공", null);
		}			
	}
	
	@PutMapping("/pw/change")
	public @ResponseBody CMRespDto<String> pwChange(@RequestBody ChangePwDto dto) {
		System.out.println(userId);
		System.out.println(dto.getPassword());
		
		User userEntity = userRepository.mPwChange(userId, dto.getPassword());
		
		return new CMRespDto<>(1, "비번 변경 완료", null);
	}

	// 로그인 기능--------------------------------------------
	@PostMapping("/login")
	public @ResponseBody String login(@Valid LoginReqDto dto, BindingResult bindingResult) {
        
		// username password 
        
           System.out.println(dto.getUsername());
           System.out.println(dto.getPassword());
        
           // validation
           System.out.println("에러사이즈: " + bindingResult.getFieldErrors().size());
           if(bindingResult.hasErrors()) { 
              Map<String, String> errorMap = new HashMap<>();
              for(FieldError error : bindingResult.getFieldErrors()) {
              errorMap.put(error.getField(), error.getDefaultMessage());
           System.out.println("필드: " + error.getField());
              System.out.println("메시지: " + error.getDefaultMessage());
              }
           return Script.back(errorMap.toString());
           }
      String encPassword = SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256);
      dto.setPassword(encPassword);

      // db
      User userEntity = userRepository.mLogin(dto.getUsername(), dto.getPassword());
      if(userEntity == null) {
    	  	return Script.back("아이디 혹은 비밀번호를 잘못 입력하였습니다");
      }else {
    	  	session.setAttribute("principal", userEntity); 
    	  	return Script.href("/","로그인 완료");
      }

     }
	// 회원가입 기능 --------------------------------------------
	@PostMapping("/join")
	public @ResponseBody String join(@Valid JoinReqDto dto, BindingResult bindingResult ) {
		
		String authKey = authEmailRepository.mFindAuthKey(dto.getAuthKey());
		System.out.println(authKey+"dasfasfadsdf");
		
		if(authKey==dto.getAuthKey()) {
			return Script.back("인증번호를 잘못 입력하였습니다.");
		}
		
		// 유효성
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				System.out.println("필드 : " + error.getField());
				System.out.println("메세지 : " + error.getDefaultMessage());
			}
			return Script.back(errorMap.toString());
		}
		
		// 아이디, 전화번호, 이메일 중복확인
		String idCheck = userRepository.mIdCheck(dto.getUsername());
		String phoneCheck = userRepository.mPhoneCheck(dto.getPhone());
		String emailCheck = userRepository.mEmailCheck(dto.getEmail());
		
		if(idCheck != null) {
			return Script.back("존재하는 아이디입니다");
		}
		if(emailCheck != null) {
			return Script.back("존재하는 이메일입니다");
		}
		if(phoneCheck != null) {
			return Script.back("존재하는 전화번호입니다");
		}
		
		// 입력받은 비밀번호 해쉬값으로 변경
		String encPassword = SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256);
		// 패스워드를 해쉬패스워드로 저장하려고
		dto.setPassword(encPassword);
		
		if(dto.getUsername().equals("ssar")) {
			dto.setAuthority("admin");
		} else {
			dto.setAuthority("guest");
		}
		
		// save = insert
		userRepository.save(dto.toEntity());
		
		return Script.href("/user/loginForm"); 
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

	@GetMapping("/user/pwFind")
	public String userPwFind() {

		return "user/pwFind";
	}

	@GetMapping("/admin/home")
	public String adminHome() {

		return "admin/home";
	}
}
