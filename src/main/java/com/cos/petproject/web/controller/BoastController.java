package com.cos.petproject.web.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.cos.petproject.domain.boast.Boast;
import com.cos.petproject.domain.boast.BoastRepository;
import com.cos.petproject.domain.comment.Comment;
import com.cos.petproject.domain.comment.CommentRepository;
import com.cos.petproject.domain.user.User;
import com.cos.petproject.handler.exception.MyNotFoundException;
import com.cos.petproject.handler.exception.MyAsyncNotFoundException;
import com.cos.petproject.util.Script;
import com.cos.petproject.web.dto.CommentSaveReqDto;
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
	         return "redirect:/"+animalId+"/boast?page=0";
	      } else if(animalId == 2){
	         return "redirect:/"+animalId+"/boast?page=0";
	      } else {
	         return "redirect:/main";
	      }
	   }
	
	// 글수정 기능---------------------------------
	@PutMapping("/{animalId}/boast/{id}")
	public String update(@PathVariable int animalId, @PathVariable int id, @RequestBody @Valid BoastSaveReqDto dto, BindingResult bindingResult) {
		
		//유효성 검사(공통로직)
				if (bindingResult.hasErrors()) {
					Map<String, String> errorMap = new HashMap<>();
					for (FieldError error : bindingResult.getFieldErrors()) {
						errorMap.put(error.getField(), error.getDefaultMessage());
					}
					throw new MyAsyncNotFoundException(errorMap.toString());
				}

				//인증
				User principal = (User) session.getAttribute("principal");
				if(principal == null) {
					throw new MyAsyncNotFoundException("인증이 되지 않았습니다.");
				}
				Boast boardEntity = boastRepository.findById(id)
						.orElseThrow(()->new MyAsyncNotFoundException("해당 게실글을 찾을 수 없습니다"));
				
				if(principal.getId() != boardEntity.getUser().getId()) {
					throw new MyAsyncNotFoundException("해달 게시물의 권한이 없습니다");
				}
				
				Boast board = dto.toEntity(principal);
				board.setUser(principal);
				board.setId(id);
				boastRepository.save(board);			
				
				if(animalId == 1) {
					return "redirect:/"+animalId+"/boast/"+id;
				} else if(animalId == 2){
					return "redirect:/"+animalId+"/boast/"+id;
				} else {
					return "redirect:/main";
				}
	}
	
	// 글삭제 기능---------------------------------
	@DeleteMapping("/boast/{id}")
	public @ResponseBody String delete(@PathVariable int id) {

		boastRepository.mdeleteById(id);
		return "ok"; // @ResponseBody -> 데이터리턴!! (String = text/plain)
	}	
		

	
	// 댓글작성 기능---------------------------------
	@PostMapping("/{animalId}/boast/{id}/comment")
	public @ResponseBody String commentSave(@PathVariable int animalId, @PathVariable int id, @Valid CommentSaveReqDto dto, BindingResult bindingResult, Model model) {
		
		// 세션 가져오기
		User principal = (User) session.getAttribute("principal");
		
		// 세션이 있는지 검사
		if (principal == null) {
			throw new MyNotFoundException("인증이 되지 않았습니다.");
		}

		// 유효성 검사
		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
				System.out.println("필드: " + error.getField());
				System.out.println("메시지: " + error.getDefaultMessage());
			}
			return Script.back(errorMap.toString());
		}
		
		// 게시글을 아이디를 조건으로 조회
		Boast boastEntity = boastRepository.findById(id)
				.orElseThrow(()-> new MyNotFoundException("해당게시글을 찾을 수 없습니다."));
		
		// Comment 객체 만들기
		Comment comment = new Comment();
		comment.setContent(dto.getContent());
		comment.setUser(principal);
		comment.setBoast(boastEntity);
		
		// 댓글 save 하기
		commentRepository.save(comment);
		
		if(animalId == 1) {
			return Script.href("/"+animalId+"/boast/"+id);
		} else if(animalId == 2){
			return Script.href("/"+animalId+"/boast/"+id);
		} else {
			return Script.href("/main");
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
	public String detail(@PathVariable int animalId, @PathVariable int id, Model model) {
		
		// 게시판 조회수 증가
		boastRepository.mCounter(id);
		
		// id로 게시글 찾기
		Boast boastEntity = boastRepository.findById(id).
				orElseThrow(()-> new MyNotFoundException(id + " 페이지를 찾을 수 없습니다."));
		
		// 날짜변환
		LocalDateTime boardCreatedAt = boastEntity.getCreatedAt();
		String parseCreatedAt = boardCreatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		// 모델에 담기
		model.addAttribute("boastEntity", boastEntity);
		model.addAttribute("parseCreatedAt", parseCreatedAt);
		
		if(animalId == 1) {
			return "cat/boast/detail";
		} else if(animalId ==2) {
			return "dog/boast/detail";
		} else {
			return "redirect:/main";
		}
	}
}
