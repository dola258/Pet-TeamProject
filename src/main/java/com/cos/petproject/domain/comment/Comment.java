package com.cos.petproject.domain.comment;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.cos.petproject.domain.boast.Boast;
import com.cos.petproject.domain.qna.Qna;
import com.cos.petproject.domain.tip.Tip;
import com.cos.petproject.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //PK (자동증가 번호)

	@Column(nullable = false)
	private String content; // 내용

	@JoinColumn(name = "userId")
	@ManyToOne
	private User user;
	
	@JoinColumn(name = "boastId")
	@ManyToOne
	private Boast boast; 
	
	@JoinColumn(name = "qnaId")
	@ManyToOne
	private Qna qna; 
	
	@JoinColumn(name = "tipId")
	@ManyToOne
	private Tip tip; 
	
	private LocalDateTime createdAt;

	@PrePersist // 디비에 INSERT 되기 직전에 실행
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}
	

}