package com.cos.petproject.web.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cos.petproject.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangePwDto {
	@Size(min = 4, max = 70)
	@NotBlank
	private String password;
	
	public User toEntity() {
		User user = new User();
		user.setPassword(password);
		return user;
}
}
