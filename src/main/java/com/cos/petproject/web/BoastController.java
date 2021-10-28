package com.cos.petproject.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.petproject.domain.boast.BoastRepository;
import com.cos.petproject.domain.comment.CommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Controller
public class BoastController {
	
	private final BoastRepository boastRepository;
	private final CommentRepository commentRepository;
	private final HttpSession session;
	
	// 페이지 불러오기
	@GetMapping("/{animalId}/boast/{id}/updateForm")
	public String boastUpdateForm(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "cat/boast/updateForm";
		} else {
			return "dog/boast/udateForm";
		}
	}

	@GetMapping("{animalId}/boast/saveForm")
	public String boastSaveForm(@PathVariable int animalId) {
		if(animalId == 1) {
			return "cat/boast/saveForm";
		} else {
			return "dog/boast/saveForm";
		}
	}
	
	@GetMapping("/{animalId}/boast")
	public String home(@PathVariable int animalId) {
		if(animalId == 1) {
			return "cat/boast/list";
		} else {
			return "dog/boast/list";
		}
	}
	
	@GetMapping("/{animalId}/boast/{id}")
	public String detail(@PathVariable int animalId, @PathVariable int id) {
		
		if(animalId == 1) {
			return "cat/boast/detail";
		} else {
			return "dog/boast/detail";
		}
	}
}
