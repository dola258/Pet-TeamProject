package com.cos.petproject.domain.authMail;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class AuthEmail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 50)
	private String email;

	private String authKey;

	private LocalDateTime createdAt;

	@PrePersist // 디비에 INSERT 되기 직전에 실행
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}
}
