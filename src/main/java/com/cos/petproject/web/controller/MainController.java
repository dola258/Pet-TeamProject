package com.cos.petproject.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.petproject.domain.boast.Boast;
import com.cos.petproject.domain.boast.BoastRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	
	private final BoastRepository boastRepository;
	
	
	@GetMapping("/main")
	public String home(Model model) {
		
		// 조회수 많은 3개 글 
	    List<Boast> mainRanks = boastRepository.mMain();	
	    List<String> image = new ArrayList<String>();
		Iterator<Boast> it = mainRanks.iterator();

		while(it.hasNext()) {
			Boast mainRank = it.next();
			//System.out.println("dto title:"+mainRank.getContent());

			//Jsoup를 이용해서 첫번째 img의 src의 값을 파싱한 후 값을 저장
			Document doc = Jsoup.parse(mainRank.getContent());
			try {
				String src = doc.selectFirst("img").attr("src");
				//mainRank.setContent(src);
				image.add(src);
				//System.out.println(src);
			} catch (Exception e) {
				System.out.println("이미지 소스를 찾을 수 없습니다. " + e.getMessage());
				image.add("사진이 없습니다!");
			}
		}

	    //System.out.println(mainRank);
		model.addAttribute("image", image);
	    model.addAttribute("mainEntity", mainRanks);

		
		
		return "main/main";
	}
}
