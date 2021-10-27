package com.cos.petproject.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentSaveReqDto {
	@NotBlank
	@Size(min = 1, max = 255)
	private String content;
}
