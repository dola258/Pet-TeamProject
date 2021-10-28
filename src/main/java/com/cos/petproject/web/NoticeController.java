package com.cos.petproject.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.petproject.domain.notice.NoticeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Controller
public class NoticeController {
	private final NoticeRepository noticeRepository;
	private final HttpSession session;
	
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
