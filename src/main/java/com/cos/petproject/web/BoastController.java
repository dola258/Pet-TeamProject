package com.cos.petproject.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cos.petproject.domain.boast.BoastRepository;
import com.cos.petproject.domain.comment.CommentRepository;
import com.cos.petproject.util.Script;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Controller
public class BoastController {
	
	private final BoastRepository boastRepository;
	private final CommentRepository commentRepository;
	private final HttpSession session;
	
	// 글작성 기능---------------------------------
	@PostMapping("/{animalId}/boast")
	public String save(@PathVariable int animalId) {
		if(animalId == 1) {
			return "redirect:/"+animalId+"/boast";
		} else if(animalId == 2){
			return "redirect:/"+animalId+"/boast";
		} else {
			return "redirect:/main";
		}
	}
	
	// 글수정 기능---------------------------------
	@PutMapping("/{animalId}/boast/{id}")
	public String update(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "redirect:/"+animalId+"/boast/"+id;
		} else if(animalId == 2){
			return "redirect:/"+animalId+"/boast/"+id;
		} else {
			return "redirect:/main";
		}
	}
	
	// 글삭제 기능---------------------------------
	@DeleteMapping("/{animalId}/boast/{id}")
	public String delete(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "redirect:/"+animalId+"/boast";
		} else if(animalId == 2){
			return "redirect:/"+animalId+"/boast";
		} else {
			return "redirect:/main";
		}
	}
	
	// 댓글작성 기능---------------------------------
	@PostMapping("/{animalId}/boast/{id}/comment")
	public String commentSave(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "redirect:/"+animalId+"/boast/"+id;
		} else if(animalId == 2){
			return "redirect:/"+animalId+"/boast/"+id;
		} else {
			return "redirect:/main";
		}
	}
	
	
	// 페이지 불러오기
	@GetMapping("/{animalId}/boast/{id}/updateForm")
	public String boastUpdateForm(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "cat/boast/updateForm";
		} else if(animalId == 2) {
			return "dog/boast/updateForm";
		} else {
			return "redirect:/main";
		}
	}

	@GetMapping("{animalId}/boast/saveForm")
	public String boastSaveForm(@PathVariable int animalId) {
		if(animalId == 1) {
			return "cat/boast/saveForm";
		} else if(animalId == 2) {
			return "dog/boast/saveForm";
		} else {
			return "redirect:/main";
		}
	}
	
	@GetMapping("/{animalId}/boast")
	public String home(@PathVariable int animalId) {
		if(animalId == 1) {
			return "cat/boast/list";
		} else if(animalId == 2){
			return "dog/boast/list";
		} else {
			return "redirect:/main";
		}
	}
	
	@GetMapping("/{animalId}/boast/{id}")
	public String detail(@PathVariable int animalId, @PathVariable int id) {
		
		if(animalId == 1) {
			return "cat/boast/detail";
		} else if(animalId ==2) {
			return "dog/boast/detail";
		} else {
			return "redirect:/main";
		}
	}
}
