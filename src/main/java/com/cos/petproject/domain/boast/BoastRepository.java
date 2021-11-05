package com.cos.petproject.domain.boast;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.petproject.domain.user.User;

public interface BoastRepository extends JpaRepository<Boast, Integer>{
	// 성준
	//글 작성
	@Query(value = "INSERT INTO boast(content, counter, title, animalId, userId, createdAt) VALUES(:content, 0, :title, :animalId, :userId, now());", nativeQuery = true)
	void mSave(String content, String title, int animalId, User userId);
	// 게시판 조회수 증가를 위한 쿼리
	@Query(value = "Update boast Set counter = counter + 1 where id = :id", nativeQuery = true)
	void mCounter(int id);
	
	// 효빈
	// 글 삭제
	@Query(value = "delete from boast where id = :id", nativeQuery = true)
	void mdeleteById(int id);
	
	// 재영
	
	// 주원
}
