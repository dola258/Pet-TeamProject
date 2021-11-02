package com.cos.petproject.web.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IdFindDto {

	@Size(min = 2, max = 20)
	@NotBlank
	private String name;
	
	@Size(min = 4, max = 10)
	@NotBlank
	private String birth;
	
	@Size(min = 4, max = 50)
	@NotBlank
	private String email;
}
