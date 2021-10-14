package com.cos.petproject.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	// 유저 관련-------------------
	@GetMapping("/user/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	@GetMapping("/user/joinForm")
	public String joForm() {
		return "user/joinForm";
	}
	@GetMapping("/user/detail")
	public String userDetail() {
		return "user/detail";
	}
	@GetMapping("/user/updateForm")
	public String userUpdateForm() {
		return "user/updateForm";
	}

	//고양이/QnA---------------------------
	@GetMapping("/cat/qna/detail")
	public String catQnaDetail() {
		return "cat/qna/detail";
	}
	@GetMapping("/cat/qna/list")
	public String catQnaList() {
		return "cat/qna/list";
	}
	@GetMapping("/cat/qna/saveForm")
	public String catQnaSaveForm() {
		return "cat/qna/saveForm";
	}
	@GetMapping("/cat/qna/updateForm")
	public String catQnaupdateForm() {
		return "cat/qna/updateForm";
	}
	//고양이/꿀팁---------------------------
	@GetMapping("/cat/tip/detail")
	public String catTipDetail() {
		return "cat/tip/detail";
	}
	@GetMapping("/cat/tip/list")
	public String catTipList() {
		return "cat/tip/list";
	}
	@GetMapping("/cat/tip/saveForm")
	public String catTipSaveForm() {
		return "cat/tip/saveForm";
	}
	@GetMapping("/dog/tip/updateForm")
	public String dogTipupdateForm() {
		return "dog/tip/updateForm";
	}
	//고양이/자랑하기---------------------------
	@GetMapping("/cat/boast/detail")
	public String catBoastDetail() {
		return "cat/boast/detail";
	}
	@GetMapping("/cat/boast/list")
	public String catBoastList() {
		return "cat/boast/list";
	}
	@GetMapping("/cat/boast/saveForm")
	public String catBoastSaveForm() {
		return "cat/boast/saveForm";
	}
	@GetMapping("/cat/boast/updateForm")
	public String catBoastupdateForm() {
		return "cat/boast/updateForm";
	}

	//강아지/QnA---------------------------
	@GetMapping("/dog/qna/detail")
	public String dogQnaDetail() {
		return "dog/qna/detail";
	}
	@GetMapping("/dog/qna/list")
	public String dogQnaList() {
		return "dog/qna/list";
	}
	@GetMapping("/dog/qna/saveForm")
	public String dogQnaSaveForm() {
		return "dog/qna/saveForm";
	}
	@GetMapping("/dog/qna/updateForm")
	public String dogQnaupdateForm() {
		return "dog/qna/updateForm";
	}
	//강아지/꿀팁---------------------------
	@GetMapping("/dog/tip/detail")
	public String dogTipDetail() {
		return "dog/tip/detail";
	}
	@GetMapping("/dog/tip/list")
	public String dogTipList() {
		return "dog/tip/list";
	}
	@GetMapping("/dog/tip/saveForm")
	public String dogTipSaveForm() {
		return "dog/tip/saveForm";
	}
	@GetMapping("/cat/tip/updateForm")
	public String catTipupdateForm() {
		return "cat/tip/updateForm";
	}
	//강아지/자랑하기---------------------------
	@GetMapping("/dog/boast/detail")
	public String dogBoastDetail() {
		return "dog/boast/detail";
	}
	@GetMapping("/dog/boast/list")
	public String dogBoastList() {
		return "dog/boast/list";
	}
	@GetMapping("/dog/boast/saveForm")
	public String dogBoastSaveForm() {
		return "dog/boast/saveForm";
	}
	@GetMapping("/dog/boast/updateForm")
	public String dogBoastupdateForm() {
		return "dog/boast/updateForm";
	}
	
	//공지사항------------------------------------------------
	@GetMapping("/notice/detail")
	public String noticeDetail() {
		return "notice/detail";
	}
	@GetMapping("/notice/list")
	public String noticeList() {
		return "notice/list";
	}
	@GetMapping("/notice/saveForm")
	public String noticeSaveForm() {
		return "notice/saveForm";
	}
	@GetMapping("/notice/updateForm")
	public String noticeUpdateForm() {
		return "notice/updateForm";
	}
}
