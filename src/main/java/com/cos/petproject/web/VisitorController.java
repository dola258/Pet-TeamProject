package com.cos.petproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.petproject.domain.visitor.VisitorRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class VisitorController {
	
	private final VisitorRepository visitorRepository;
	
	@GetMapping("/vistor")
	public String home() {
		return "/";
	}
}
