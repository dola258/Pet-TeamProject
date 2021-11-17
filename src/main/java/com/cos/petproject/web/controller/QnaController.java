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

import com.cos.petproject.domain.comment.CommentRepository;
import com.cos.petproject.domain.qna.Qna;
import com.cos.petproject.domain.qna.QnaRepository;
import com.cos.petproject.domain.user.User;
import com.cos.petproject.handler.exception.MyAsyncNotFoundException;
import com.cos.petproject.handler.exception.MyNotFoundException;
import com.cos.petproject.service.CommentService;
import com.cos.petproject.service.board.QnaService;
import com.cos.petproject.util.Script;
import com.cos.petproject.web.dto.CMRespDto;
import com.cos.petproject.web.dto.CommentSaveReqDto;
import com.cos.petproject.web.dto.board.QnaSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QnaController {

	private final QnaRepository qnaRepository;
	private final CommentRepository commentRepository;
	private final HttpSession session;
	private final QnaService qnaService;
	private final CommentService commetService;
	
	// 글작성 기능---------------------------------
	@PostMapping("/api/{animalId}/qna")
	public @ResponseBody String save(@PathVariable int animalId, @Valid QnaSaveReqDto dto,
			BindingResult bindingResult) {

		User principal = (User) session.getAttribute("principal");

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
		
		qnaService.게시글등록(dto, animalId, principal);
		
		if (animalId == 1) {
			return Script.href("/" + animalId + "/qna?page=0");
		} else if (animalId == 2) {
			return Script.href("/" + animalId + "/qna?page=0");
		} else {
			return Script.href("/main");
		}
	}

	// 글수정 기능---------------------------------
	@PutMapping("/api/{animalId}/qna/{id}")
	public @ResponseBody CMRespDto<String> update(@PathVariable int animalId, @PathVariable int id,
			@RequestBody @Valid QnaSaveReqDto dto, BindingResult bindingResult) {

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
	
		qnaService.게시글수정(principal, id, animalId, dto);
		
		return new CMRespDto<>(1, "업데이트 성공", null);

	}

	// 글삭제 기능---------------------------------
	@DeleteMapping("/api/qna/{id}")
	public @ResponseBody CMRespDto<String> delete(@PathVariable int id) {

		System.out.println(id);

		// 인증이 된 사람만 함수 접근 가능!! (로그인 된 사람)
		User principal = (User) session.getAttribute("principal");
		
		if (!principal.getAuthority().equals("admin")) {
			throw new MyAsyncNotFoundException("인증이 되지 않았습니다.");
		}

		qnaService.게시글삭제(principal, id);

		return new CMRespDto<String>(1, "성공", null); // @ResponseBody 데이터 리턴!! String
	}

	// 댓글작성 기능---------------------------------
	@PostMapping("/api/{animalId}/qna/{id}/comment")
	public @ResponseBody String commentSave(@PathVariable int animalId, @PathVariable int id,
			@Valid CommentSaveReqDto dto, BindingResult bindingResult, Model model) {

		// 세션 가져오기
		User principal = (User) session.getAttribute("principal");

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

		commetService.QnA댓글등록(id, dto, principal);

		if (animalId == 1) {
			return Script.href("/" + animalId + "/qna/" + id);
		} else if (animalId == 2) {
			return Script.href("/" + animalId + "/qna/" + id);
		} else {
			return Script.href("/main");
		}
	}

	// 페이지 불러오기
	@GetMapping("/{animalId}/qna/{id}/updateForm")
	public String qnaUpdateForm(@PathVariable int animalId, @PathVariable int id, Model model) {

		Qna qnaEntity = qnaService.게시글수정페이지이동(id);
		
		LocalDateTime boardCreatedAt = qnaEntity.getCreatedAt();
		String parseCreatedAt = boardCreatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		model.addAttribute("qnaEntity", qnaEntity);
		model.addAttribute("parseCreatedAt", parseCreatedAt);

		if (animalId == 1) {
			return "cat/qna/updateForm";
		} else if (animalId == 2) {
			return "dog/qna/updateForm";
		} else {
			return "redirect:/main";
		}
	}

	@GetMapping("{animalId}/qna/saveForm")
	public String qnaSaveForm(@PathVariable int animalId) {
		if (animalId == 1) {
			return "cat/qna/saveForm";
		} else if (animalId == 2) {
			return "dog/qna/saveForm";
		} else {
			return "redirect:/main";
		}
	}

	@GetMapping("{animalId}/qna")
	public String home(@PathVariable int animalId, @RequestParam int page, Model model) {
	
		Page<Qna> qnaEntity = qnaService.게시글목록보기(page, animalId);
		
		int pageNumber = qnaEntity.getPageable().getPageNumber();
		int pageBlock = 10;
		int startBlockPage = ((pageNumber) / pageBlock) * pageBlock + 1;
		int endBlockPage = startBlockPage + pageBlock - 1;
		
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		model.addAttribute("qnaEntity", qnaEntity);
		
		if (animalId == 1) {
			return "cat/qna/list";
		} else if (animalId == 2) {
			return "dog/qna/list";
		} else {
			return "redirect:/main";
		}
	}

	@GetMapping("/{animalId}/qna/{id}")
	public String detail(@PathVariable int animalId, @PathVariable int id, Model model) {

		// 게시판 조회수 증가
		qnaRepository.mCounter(id);
		
		Qna qnaEntity = qnaService.게시글상세보기(id);
		
		// 날짜변환
		LocalDateTime boardCreatedAt = qnaEntity.getCreatedAt();
		String parseCreatedAt = boardCreatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		// 모델에 담기
		model.addAttribute("qnaEntity", qnaEntity);
		model.addAttribute("parseCreatedAt", parseCreatedAt);

		if (animalId == 1) {
			return "cat/qna/detail";
		} else if (animalId == 2) {
			return "dog/qna/detail";
		} else {
			return "redirect:/main";
		}
	}
}