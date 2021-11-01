package com.cos.petproject.web.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cos.petproject.domain.comment.CommentRepository;
import com.cos.petproject.domain.tip.TipRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Controller
public class TipController {
	
	private final TipRepository tipRepository;
	private final CommentRepository commentRepository;
	private final HttpSession session;
	
	
	// 글작성 기능---------------------------------
	@PostMapping("/{animalId}/tip")
	public String save(@PathVariable int animalId) {
		if(animalId == 1) {
			return "redirect:/"+animalId+"/tip";
		} else if(animalId == 2){
			return "redirect:/"+animalId+"/tip";
		} else {
			return "redirect:/main";
		}
	}
	
	// 글수정 기능---------------------------------
	@PutMapping("/{animalId}/tip/{id}")
	public String update(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "redirect:/"+animalId+"/tip/"+id;
		} else if(animalId == 2){
			return "redirect:/"+animalId+"/tip/"+id;
		} else {
			return "redirect:/main";
		}
	}
	
	// 글삭제 기능---------------------------------
	@DeleteMapping("/{animalId}/tip/{id}")
	public String delete(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "redirect:/"+animalId+"/tip";
		} else if(animalId == 2){
			return "redirect:/"+animalId+"/tip";
		} else {
			return "redirect:/main";
		}
	}
	
	// 댓글작성 기능---------------------------------
	@PostMapping("/{animalId}/tip/{id}/comment")
	public String commentSave(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "redirect:/"+animalId+"/tip/"+id;
		} else if(animalId == 2){
			return "redirect:/"+animalId+"/tip/"+id;
		} else {
			return "redirect:/main";
		}
	}
	
	
	// 페이지 불러오기
	@GetMapping("/{animalId}/tip/{id}/updateForm")
	public String tipUpdateForm(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "cat/tip/updateForm";
		} else if(animalId == 2){
			return "dog/tip/updateForm";
		} else {
			return "redirect:/main";
		}
	}

	@GetMapping("{animalId}/tip/saveForm")
	public String tipSaveForm(@PathVariable int animalId) {
		if(animalId == 1) {
			return "cat/tip/saveForm";
		} else if(animalId == 2) {
			return "dog/tip/saveForm";
		} else {
			return "redirect:/main";
		}
	}
	
	@GetMapping("/{animalId}/tip")
	public String home(@PathVariable int animalId) {
		if(animalId == 1) {
			return "cat/tip/list";
		} else if(animalId == 2) {
			return "dog/tip/list";
		} else {
			return "redirect:/main";
		}
	}
	
	@GetMapping("/{animalId}/tip/{id}")
	public String detail(@PathVariable int animalId, @PathVariable int id) {
		
		if(animalId == 1) {
			return "cat/tip/detail";
		} else if(animalId == 2) {
			return "dog/tip/detail";
		} else {
			return "redirect:/main";
		}
	}

}
