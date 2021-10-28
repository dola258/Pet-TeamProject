package com.cos.petproject.web;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.petproject.domain.comment.CommentRepository;
import com.cos.petproject.domain.tip.TipRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Controller
public class TipController {
	
	private final TipRepository tipRepository;
	private final CommentRepository commentRepository;
	private final HttpSession session;
	
	
	// 페이지 불러오기
	@GetMapping("/{animalId}/tip/{id}/updateForm")
	public String tipUpdateForm(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "cat/tip/updateForm";
		} else {
			return "dog/tip/udateForm";
		}
	}

	@GetMapping("{animalId}/tip/saveForm")
	public String tipSaveForm(@PathVariable int animalId) {
		if(animalId == 1) {
			return "cat/tip/saveForm";
		} else {
			return "dog/tip/saveForm";
		}
	}
	
	@GetMapping("/{animalId}/tip")
	public String home(@PathVariable int animalId) {
		if(animalId == 1) {
			return "cat/tip/list";
		} else {
			return "dog/tip/list";
		}
	}
	
	@GetMapping("/{animalId}/tip/{id}")
	public String detail(@PathVariable int animalId, @PathVariable int id) {
		
		if(animalId == 1) {
			return "cat/tip/detail";
		} else {
			return "dog/tip/detail";
		}
	}

}
