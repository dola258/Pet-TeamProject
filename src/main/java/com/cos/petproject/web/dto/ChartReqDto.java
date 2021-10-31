package com.cos.petproject.web.dto;

import java.util.Date;

import com.cos.petproject.domain.visitor.Visitor;

public class ChartReqDto {
	private int id;
	private Date time;
	
	public Visitor toEntity() {
		Visitor visitor = Visitor.builder()
				.id(id)
				.time(time)
				.build();
		return visitor;
	}


}
