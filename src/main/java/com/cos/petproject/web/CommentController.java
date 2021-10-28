package com.cos.petproject.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cos.petproject.domain.comment.CommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Controller
public class CommentController {
	
	private final CommentRepository commentRepository;
	private final HttpSession session;
	
	
	// 댓글 삭제기능 ------------------------------------------
	@DeleteMapping("/comment/{id}")
	public void deleteById() {
		
	}
	
	
	// 댓글 수정기능 ------------------------------------------
	@PutMapping("/comment/{id}")
	public void update() {
		
	}
}
