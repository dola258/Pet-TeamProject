package com.cos.petproject.web.dto.board;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cos.petproject.domain.tip.Tip;
import com.cos.petproject.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipSaveReqDto {

	@Size(min = 1, max = 50)
	@NotBlank
	private String title;
	private String content;
	
	public Tip toEntity(User principal) {
		Tip tip = new Tip();
		tip.setTitle(title);
		tip.setContent(content);
		tip.setUser(principal);
		return tip;
	}
}