package com.cos.petproject.web;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	
	// 글작성 기능---------------------------------
	@PostMapping("/{animalId}/qna")
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
	@PutMapping("/{animalId}/qna/{id}")
	public String update(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "redirect:/"+animalId+"/qna/"+id;
		} else if(animalId == 2){
			return "redirect:/"+animalId+"/qna/"+id;
		} else {
			return "redirect:/main";
		}
	}
	
	// 글삭제 기능---------------------------------
	@DeleteMapping("/{animalId}/qna/{id}")
	public String delete(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "redirect:/"+animalId+"/qna";
		} else if(animalId == 2){
			return "redirect:/"+animalId+"/qna";
		} else {
			return "redirect:/main";
		}
	}
	
	// 댓글작성 기능---------------------------------
	@PostMapping("/{animalId}/qna/{id}/comment")
	public String commentSave(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "redirect:/"+animalId+"/qna/"+id;
		} else if(animalId == 2){
			return "redirect:/"+animalId+"/qna/"+id;
		} else {
			return "redirect:/main";
		}
	}
	
	// 페이지 불러오기
	@GetMapping("/{animalId}/qna/{id}/updateForm")
	public String qnaUpdateForm(@PathVariable int animalId, @PathVariable int id) {
		if(animalId == 1) {
			return "cat/qna/updateForm";
		} else {
			return "dog/qna/updateForm";
		}
	}

	@GetMapping("{animalId}/qna/saveForm")
	public String qnaSaveForm(@PathVariable int animalId) {
		if(animalId == 1) {
			return "cat/qna/saveForm";
		} else if(animalId == 2) {
			return "dog/qna/saveForm";
		} else {
			return "redirect:/main";
		}
	}
	
	@GetMapping("/{animalId}/qna")
	public String home(@PathVariable int animalId) {
		if(animalId == 1) {
			return "cat/qna/list";
		} else if(animalId == 2){
			return "dog/qna/list";
		} else {
			return "redirect:/main";
		}
	}
	
	@GetMapping("/{animalId}/qna/{id}")
	public String detail(@PathVariable int animalId, @PathVariable int id) {
		
		if(animalId == 1) {
			return "cat/qna/detail";
		} else if(animalId == 2) {
			return "dog/qna/detail";
		} else {
			return "redirect:/main";
		}
	}
}
