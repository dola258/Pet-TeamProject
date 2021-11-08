package com.cos.petproject.domain.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.petproject.domain.user.User;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
	
	@Query(value = "INSERT INTO notice(title, content, userId, createdAt, counter) VALUES(:title, :content, :userId, now(), 0);", nativeQuery = true)
	void mSave(String title, String content, User userId);

	// 게시판 조회수 증가를 위한 쿼리
	@Query(value = "Update notice Set counter = counter + 1 where id = :id", nativeQuery = true)
	void mCounter(int id);
}
