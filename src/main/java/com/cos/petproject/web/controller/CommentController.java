package com.cos.petproject.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.petproject.domain.comment.Comment;
import com.cos.petproject.domain.comment.CommentRepository;
import com.cos.petproject.domain.user.User;
import com.cos.petproject.handler.exception.MyAsyncNotFoundException;
import com.cos.petproject.service.CommentService;
import com.cos.petproject.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Controller
public class CommentController {
	
	private final CommentRepository commentRepository;
	private final HttpSession session;
	private final CommentService commentService;
	
	// 댓글 삭제기능 ------------------------------------------
	@DeleteMapping("/comment/{id}")
	public @ResponseBody CMRespDto<String> deleteById(@PathVariable int id) {
		
		
		User principal = (User) session.getAttribute("principal");
		if(principal == null) {
			throw new MyAsyncNotFoundException("인증되지 않은 사용자입니다");
		}
		
		commentService.댓글삭제(id, principal);
		
		return new CMRespDto<String>(1, "성공", null);

	}
	
	
	// 댓글 수정기능 ------------------------------------------
	@PutMapping("/comment/{id}")
	public void update() {
		
	}
}
