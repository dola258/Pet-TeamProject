package com.cos.petproject.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cos.petproject.domain.boast.BoastRepository;
import com.cos.petproject.domain.comment.CommentRepository;
import com.cos.petproject.domain.user.User;
import com.cos.petproject.util.Script;
import com.cos.petproject.web.dto.board.BoastSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Controller
public class BoastController {
	
	private final BoastRepository boastRepository;
	private final CommentRepository commentRepository;
	private final HttpSession session;
	
	// 글작성 기능---------------------------------
	   @PostMapping("/{animalId}/boast")
	   public String save(@PathVariable int animalId, @Valid BoastSaveReqDto dto, BindingResult bindingResult) {
	      	      
	      User principal = (User) session.getAttribute("principal");
	      
	      // 인증
	      if(principal == null) { // 로그인 안됨
	         return Script.href("/loginForm", "잘못된 접근입니다");
	      }
	      
	      // 유효성 검사
	      if(bindingResult.hasErrors()) {
	         Map<String, String> errorMap = new HashMap<>();
	         for(FieldError error : bindingResult.getFieldErrors()) {
	            errorMap.put(error.getField(), error.getDefaultMessage());
	            System.out.println("필드: " + error.getField());
	            System.out.println("메시지: " + error.getDefaultMessage());
	         }
	         return Script.back(errorMap.toString());
	      }
	      
	      // <p> 태그 제거
	      dto.setContent(dto.getContent().replaceAll("<p>", ""));
	      dto.setContent(dto.getContent().replaceAll("</p>", ""));
	      
	      // 글 작성
	      boastRepository.mSave(dto.getContent(), dto.getTitle(), animalId, principal);
	      
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
