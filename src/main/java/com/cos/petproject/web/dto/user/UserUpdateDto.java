package com.cos.petproject.web.dto.user;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
	@NotBlank
	private String password;
	@NotBlank
	private String nickname;
	@NotBlank
	private String email;
	@NotBlank
	private String phone;
}
