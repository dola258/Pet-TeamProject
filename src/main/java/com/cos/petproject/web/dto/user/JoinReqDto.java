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
public class JoinReqDto {
	private int id;
	
	@Size(min = 2, max = 20)
	@NotBlank
	private String username;
	
	@Size(min = 4, max = 20)
	@NotBlank
	private String password;
	
	@Size(min = 4, max = 20)
	@NotBlank
	private String name;
	
	@Size(min = 4, max = 20)
	@NotBlank
	private String nickname;
	
	@Size(min = 4, max = 20)
	@NotBlank
	private String phone;
	
	@Size(min = 4, max = 50)
	@NotBlank
	private String email;
	
	@Size(min = 4, max = 50)
	@NotBlank
	private String gender;
	
	@Size(min = 4, max = 50)
	@NotBlank
	private String birth;
	
	@Size(min = 4, max = 20)
	@NotBlank
	private String authority;
	
	
	
	
	public User toEntity() {
		User user = new User();
		
		if(id == 1) {
			authority = "admin";
		} else {
			authority = "guest";
		}
		
		
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setNickname(nickname);
		user.setPhone(phone);
		user.setEmail(email);
		user.setGender(gender);
		user.setBirth(birth);
		user.setAuthority(authority);
		
		return user;
	}
}



