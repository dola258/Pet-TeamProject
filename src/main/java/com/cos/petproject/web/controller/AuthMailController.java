package com.cos.petproject.web.controller;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.petproject.domain.authMail.AuthEmailRepository;
import com.cos.petproject.handler.exception.MyAsyncNotFoundException;
import com.cos.petproject.service.AuthEmailService;
import com.cos.petproject.web.dto.AuthEmailReqDto;
import com.cos.petproject.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthMailController {
	
	private final AuthEmailService authEmailService;
	private final AuthEmailRepository authEmailRepository;
	
	
	
	// 인증번호 발송 및 authKey 생성
    @PostMapping("/user/email/join")
    public @ResponseBody CMRespDto<String> emailTest(@Valid @RequestBody AuthEmailReqDto dto, Model model, BindingResult bindingResult){
    	System.out.println("email: " + dto.getEmail());
    	
    	// 유효성 검사
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				System.out.println("필드: " + error.getField());
				System.out.println("메시지: " + error.getDefaultMessage());
			}
			throw new MyAsyncNotFoundException(errorMap.toString());
		}
    	
		authEmailService.인증번호발송(dto);
		
		return new CMRespDto<String>(1, "성공", null);
    }
	
    // 인증번호 검증
    @PostMapping("/user/email/check")
    public @ResponseBody CMRespDto<String> authChk(@RequestBody AuthEmailReqDto dto){
    	
    	authEmailService.인증번호검증(dto);
    	
		return new CMRespDto<String>(1, "성공", null);
    	
    }
}
