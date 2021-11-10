package com.cos.petproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {

	@GetMapping("/map")
	public String map() {
		return "map/map";
	}
}
