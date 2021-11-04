package com.cos.petproject.web.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
	@NotBlank
	@Size(min = 4, max = 70)
	private String password;
	@NotBlank
	@Size(min = 2, max = 20)
	private String nickname;
	@NotBlank
	@Size(min = 4, max = 50)
	private String email;
	@Size(min = 10, max = 11)
	@NotBlank
	private String phone;
	@Size(min = 6)
	@NotBlank
	private String authKey;
}
