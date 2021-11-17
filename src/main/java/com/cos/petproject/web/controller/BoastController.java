package com.cos.petproject.web.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.petproject.domain.boast.Boast;
import com.cos.petproject.domain.boast.BoastRepository;
import com.cos.petproject.domain.comment.CommentRepository;
import com.cos.petproject.domain.user.User;
import com.cos.petproject.handler.exception.MyAsyncNotFoundException;
import com.cos.petproject.handler.exception.MyNotFoundException;
import com.cos.petproject.service.CommentService;
import com.cos.petproject.service.board.BoastService;
import com.cos.petproject.util.Script;
import com.cos.petproject.web.dto.CMRespDto;
import com.cos.petproject.web.dto.CommentSaveReqDto;
import com.cos.petproject.web.dto.board.BoastSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoastController {

	private final BoastRepository boastRepository;
	private final HttpSession session;
	private final BoastService boastService;
	private final CommentService commetService;
	
	
	// 글작성 기능---------------------------------
	@PostMapping("/{animalId}/boast")
	public @ResponseBody String save(@PathVariable int animalId, @Valid BoastSaveReqDto dto,
			BindingResult bindingResult) {

		User principal = (User) session.getAttribute("principal");

		// 인증
		if (principal == null) { // 로그인 안됨
			return Script.href("/user/loginForm", "잘못된 접근입니다");
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

		// <p> 태그 제거
		dto.setContent(dto.getContent().replaceAll("<p>", ""));
		dto.setContent(dto.getContent().replaceAll("</p>", ""));

		boastService.게시글등록(dto, animalId, principal);
			
		if (animalId == 1) {
			return Script.href("/" + animalId + "/boast?page=0");
		} else if (animalId == 2) {
			return Script.href("/" + animalId + "/boast?page=0");
		} else {
			return Script.href("/main");
		}
	}

	// 글수정 기능---------------------------------
	@PutMapping("/{animalId}/boast/{id}")
	public @ResponseBody CMRespDto<String> update(@PathVariable int animalId, @PathVariable int id,
			@RequestBody @Valid BoastSaveReqDto dto, BindingResult bindingResult) {

		// 유효성 검사(공통로직)
		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			throw new MyAsyncNotFoundException(errorMap.toString());
		}

		// 인증
		User principal = (User) session.getAttribute("principal");
		if (principal == null) {
			throw new MyAsyncNotFoundException("인증이 되지 않았습니다.");
		}
		
		boastService.게시글수정(principal, id, animalId, dto);

		return new CMRespDto<>(1, "업데이트 성공", null);

	}

	// 글삭제 기능---------------------------------
	@DeleteMapping("/boast/{id}")
	public @ResponseBody CMRespDto<String> delete(@PathVariable int id) {

		System.out.println(id);

		// 인증이 된 사람만 함수 접근 가능!! (로그인 된 사람)
		User principal = (User) session.getAttribute("principal");
		if (principal == null && !principal.getAuthority().equals("admin")) {
			throw new MyAsyncNotFoundException("인증이 되지 않았습니다.");
		}

		boastService.게시글삭제(principal, id);

		return new CMRespDto<String>(1, "성공", null); // @ResponseBody 데이터 리턴!! String
	}

	// 댓글작성 기능---------------------------------
	@PostMapping("/{animalId}/boast/{id}/comment")
	public @ResponseBody String commentSave(@PathVariable int animalId, @PathVariable int id,
			@Valid CommentSaveReqDto dto, BindingResult bindingResult, Model model) {

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
		
		commetService.자랑하기댓글등록(id, dto, principal);

		if (animalId == 1) {
			return Script.href("/" + animalId + "/boast/" + id);
		} else if (animalId == 2) {
			return Script.href("/" + animalId + "/boast/" + id);
		} else {
			return Script.href("/main");
		}
	}

	// 페이지 불러오기
	@GetMapping("/{animalId}/boast/{id}/updateForm")
	public String boastUpdateForm(@PathVariable int animalId, @PathVariable int id, Model model) {

		Boast boastEntity = boastService.게시글수정페이지이동(id);
		
		LocalDateTime boardCreatedAt = boastEntity.getCreatedAt();
		String parseCreatedAt = boardCreatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		model.addAttribute("boastEntity", boastEntity);
		model.addAttribute("parseCreatedAt", parseCreatedAt);

		if (animalId == 1) {
			return "cat/boast/updateForm";
		} else if (animalId == 2) {
			return "dog/boast/updateForm";
		} else {
			return "redirect:/main";
		}
	}

	@GetMapping("{animalId}/boast/saveForm")
	public String boastSaveForm(@PathVariable int animalId) {
		if (animalId == 1) {
			return "cat/boast/saveForm";
		} else if (animalId == 2) {
			return "dog/boast/saveForm";
		} else {
			return "redirect:/main";
		}
	}

	@GetMapping("{animalId}/boast")
	public String home(@PathVariable int animalId, @RequestParam int page, Model model) {
		
		Page<Boast> boastEntity = boastService.게시글목록보기(page, animalId);
		
		int pageNumber = boastEntity.getPageable().getPageNumber();
		int pageBlock = 10;
		int startBlockPage = ((pageNumber) / pageBlock) * pageBlock + 1;
		int endBlockPage = startBlockPage + pageBlock - 1;
		
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		model.addAttribute("boastEntity", boastEntity);

		if (animalId == 1) {
			return "cat/boast/list";
		} else if (animalId == 2) {
			return "dog/boast/list";
		} else {
			return "redirect:/main";
		}
	}

	@GetMapping("/{animalId}/boast/{id}")
	public String detail(@PathVariable int animalId, @PathVariable int id, Model model) {

		// 게시판 조회수 증가
		boastRepository.mCounter(id);

		Boast boastEntity = boastService.게시글상세보기(id);
		
		// 날짜변환
		LocalDateTime boardCreatedAt = boastEntity.getCreatedAt();
		String parseCreatedAt = boardCreatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		// 모델에 담기
		model.addAttribute("boastEntity", boastEntity);
		model.addAttribute("parseCreatedAt", parseCreatedAt);

		if (animalId == 1) {
			return "cat/boast/detail";
		} else if (animalId == 2) {
			return "dog/boast/detail";
		} else {
			return "redirect:/main";
		}
	}
}
