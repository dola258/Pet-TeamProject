package com.cos.petproject.domain.qna;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.cos.petproject.domain.animal.Animal;
import com.cos.petproject.domain.comment.Comment;
import com.cos.petproject.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Qna {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //PK (자동증가 번호)
	
	@Column(nullable = false, length = 50)
	private String title; // 제목
	
	@Lob
	private String content; // 내용
	
	private int counter;
	
	@JoinColumn(name = "userId")
	@ManyToOne
	private User user;
	
	@JoinColumn(name = "animalId")
	@ManyToOne
	private Animal animal;
	
	// 양방향 매핑
	// mappedBy 에는 FK의 주인의 변수이름을 추가한다.
	@JsonIgnoreProperties({"qna"}) // comments 객체 내부의 필드를 제외시키는 법
	@OneToMany(mappedBy = "qna", fetch = FetchType.LAZY)
	@OrderBy("id desc")
	private List<Comment> comments;
	
}
