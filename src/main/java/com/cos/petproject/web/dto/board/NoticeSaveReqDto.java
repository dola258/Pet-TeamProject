package com.cos.petproject.web.dto.board;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cos.petproject.domain.notice.Notice;
import com.cos.petproject.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoticeSaveReqDto {

	@Size(min = 1, max = 50)
	@NotBlank
	private String title;
	private String content;

	public Notice toEntity(User principal) {
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setUser(principal);
		return notice;
	}
}