package com.cos.petproject.web.dto.board;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cos.petproject.domain.boast.Boast;
import com.cos.petproject.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoastSaveReqDto {

	@Size(min = 1, max = 50)
	@NotBlank
	private String title;
	private String content;
	
	public Boast toEntity(User principal) {
		Boast boast = new Boast();
		boast.setTitle(title);
		boast.setContent(content);
		boast.setUser(principal);
		return boast;
	}
}