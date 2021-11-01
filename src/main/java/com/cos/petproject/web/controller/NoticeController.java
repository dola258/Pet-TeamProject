package com.cos.petproject.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cos.petproject.domain.notice.NoticeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Controller
public class NoticeController {
	private final NoticeRepository noticeRepository;
	private final HttpSession session;
	
	
	// 글작성 기능---------------------------------
	@PostMapping("/notice")
	public String save() {
		
		return "redirect:/notic";
		
	}
	
	// 글수정 기능---------------------------------
	@PutMapping("/notice/{id}")
	public String update(@PathVariable int id) {
		
		return "redirect:/notice" + id;
	}
	
	// 글삭제 기능---------------------------------
	@DeleteMapping("/notice/{id}")
	public String delete(@PathVariable int animalId, @PathVariable int id) {
	
		return "redirect:/notice";
	}
	
	
	
	// 페이지 불러오기
	@GetMapping("/notice/{id}/updateForm")
	public String noticeUpdateForm() {
		
		return "notice/updateForm";
	}

	@GetMapping("/notice/saveForm")
	public String noticeSaveForm() {
		
		return "notice/updateForm";
	}
	
	@GetMapping("/notice")
	public String home() {
		
		return "notice/list";
	}
	
	@GetMapping("/notice/{id}")
	public String detail() {
	
		return "notice/detail"; 
	}
}
