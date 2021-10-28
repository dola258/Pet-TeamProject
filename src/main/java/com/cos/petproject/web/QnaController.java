package com.cos.petproject.web;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.petproject.domain.animal.AnimalRepository;
import com.cos.petproject.domain.comment.CommentRepository;
import com.cos.petproject.domain.qna.QnaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Controller
public class QnaController {
                                                                                                                                                                                                                                                                                                                                                                    
	private final QnaRepository qnaRepository;
	private final CommentRepository commentRepository;
	private final AnimalRepository animalRepository;
	private final HttpSession session;
	
	
	
	// 페이지 불러오기
	@GetMapping("/{animalId}/qna/{id}/updateForm")
	public String qnaUpdateForm(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "cat/qna/updateForm";
		} else {
			return "dog/qna/udateForm";
		}
	}

	@GetMapping("{animalId}/qna/saveForm")
	public String qnaSaveForm(@PathVariable int animalId) {
		if(animalId == 1) {
			return "cat/qna/saveForm";
		} else {
			return "dog/qna/saveForm";
		}
	}
	
	@GetMapping("/{animalId}/qna")
	public String home(@PathVariable int animalId) {
		if(animalId == 1) {
			return "cat/qna/list";
		} else {
			return "dog/qna/list";
		}
	}
	
	@GetMapping("/{animalId}/qna/{id}")
	public String detail(@PathVariable int animalId, @PathVariable int id) {
		
		if(animalId == 1) {
			return "cat/qna/detail";
		} else {
			return "dog/qna/detail";
		}
	}
}
