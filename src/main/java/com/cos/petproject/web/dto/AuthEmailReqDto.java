package com.cos.petproject.web.dto;

import javax.validation.constraints.NotBlank;

import com.cos.petproject.domain.authMail.AuthEmail;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthEmailReqDto {

	@NotBlank(message = "이메일을 입력하세요!")
	private String email;
	
    private String authKey;
	
	public AuthEmail toEntity() {
		AuthEmail authEmail = AuthEmail.builder()
				.email(email)
				.authKey(authKey)
				.build();
		return authEmail;
	}
}
