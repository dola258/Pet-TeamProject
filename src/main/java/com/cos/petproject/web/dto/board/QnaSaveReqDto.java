package com.cos.petproject.web.dto.board;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cos.petproject.domain.qna.Qna;
import com.cos.petproject.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QnaSaveReqDto {

	@Size(min = 1, max = 50)
	@NotBlank
	private String title;
	private String content;
	
	public Qna toEntity(User principal) {
		Qna qna = new Qna();
		qna.setTitle(title);
		qna.setContent(content);
		qna.setUser(principal);
		return qna;
	}
}