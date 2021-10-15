package com.cos.petproject.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	// 유저 관련-------------------
	@GetMapping("/test/user/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	@GetMapping("/test/user/joinForm")
	public String joForm() {
		return "user/joinForm";
	}
	@GetMapping("/test/user/detail")
	public String userDetail() {
		return "user/detail";
	}
	@GetMapping("/test/user/updateForm")
	public String userUpdateForm() {
		return "user/updateForm";
	}

	
	//고양이/QnA---------------------------
	@GetMapping("/test/cat/qna/detail")
	public String catQnaDetail() {
		return "cat/qna/detail";
	}
	@GetMapping("/test/cat/qna/list")
	public String catQnaList() {
		return "cat/qna/list";
	}
	@GetMapping("/test/cat/qna/saveForm")
	public String catQnaSaveForm() {
		return "cat/qna/saveForm";
	}
	@GetMapping("/test/cat/qna/updateForm")
	public String catQnaupdateForm() {
		return "cat/qna/updateForm";
	}
	
	
	//고양이/꿀팁---------------------------
	@GetMapping("/test/cat/tip/detail")
	public String catTipDetail() {
		return "cat/tip/detail";
	}
	@GetMapping("/test/cat/tip/list")
	public String catTipList() {
		return "cat/tip/list";
	}
	@GetMapping("/test/cat/tip/saveForm")
	public String catTipSaveForm() {
		return "cat/tip/saveForm";
	}
	@GetMapping("/test/dog/tip/updateForm")
	public String dogTipupdateForm() {
		return "dog/tip/updateForm";
	}
	
	
	//고양이/자랑하기---------------------------
	@GetMapping("/test/cat/boast/detail")
	public String catBoastDetail() {
		return "cat/boast/detail";
	}
	@GetMapping("/test/cat/boast/list")
	public String catBoastList() {
		return "cat/boast/list";
	}
	@GetMapping("/test/cat/boast/saveForm")
	public String catBoastSaveForm() {
		return "cat/boast/saveForm";
	}
	@GetMapping("/test/cat/boast/updateForm")
	public String catBoastupdateForm() {
		return "cat/boast/updateForm";
	}

	
	//강아지/QnA---------------------------
	@GetMapping("/test/dog/qna/detail")
	public String dogQnaDetail() {
		return "dog/qna/detail";
	}
	@GetMapping("/test/dog/qna/list")
	public String dogQnaList() {
		return "dog/qna/list";
	}
	@GetMapping("/test/dog/qna/saveForm")
	public String dogQnaSaveForm() {
		return "dog/qna/saveForm";
	}
	@GetMapping("/test/dog/qna/updateForm")
	public String dogQnaupdateForm() {
		return "dog/qna/updateForm";
	}
	
	
	//강아지/꿀팁---------------------------
	@GetMapping("/test/dog/tip/detail")
	public String dogTipDetail() {
		return "dog/tip/detail";
	}
	@GetMapping("/test/dog/tip/list")
	public String dogTipList() {
		return "dog/tip/list";
	}
	@GetMapping("/test/dog/tip/saveForm")
	public String dogTipSaveForm() {
		return "dog/tip/saveForm";
	}
	@GetMapping("/test/cat/tip/updateForm")
	public String catTipupdateForm() {
		return "cat/tip/updateForm";
	}
	
	
	//강아지/자랑하기---------------------------
	@GetMapping("/test/dog/boast/detail")
	public String dogBoastDetail() {
		return "dog/boast/detail";
	}
	@GetMapping("/test/dog/boast/list")
	public String dogBoastList() {
		return "dog/boast/list";
	}
	@GetMapping("/test/dog/boast/saveForm")
	public String dogBoastSaveForm() {
		return "dog/boast/saveForm";
	}
	@GetMapping("/test/dog/boast/updateForm")
	public String dogBoastupdateForm() {
		return "dog/boast/updateForm";
	}
	
	
	//공지사항------------------------------------------------
	@GetMapping("/test/notice/detail")
	public String noticeDetail() {
		return "notice/detail";
	}
	@GetMapping("/test/notice/list")
	public String noticeList() {
		return "notice/list";
	}
	@GetMapping("/test/notice/saveForm")
	public String noticeSaveForm() {
		return "notice/saveForm";
	}
	@GetMapping("/test/notice/updateForm")
	public String noticeUpdateForm() {
		return "notice/updateForm";
	}
}
