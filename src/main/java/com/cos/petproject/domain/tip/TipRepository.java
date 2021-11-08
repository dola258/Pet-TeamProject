package com.cos.petproject.domain.tip;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.petproject.domain.boast.Boast;
import com.cos.petproject.domain.user.User;

public interface TipRepository extends JpaRepository<Tip, Integer> {
	// 성준
	//글 작성
	@Query(value = "INSERT INTO tip(content, counter, title, animalId, userId, createdAt) VALUES(:content, 0, :title, :animalId, :userId, now());", nativeQuery = true)
	void mSave(String content, String title, int animalId, User userId);
	// 게시판 조회수 증가를 위한 쿼리
	@Query(value = "Update tip Set counter = counter + 1 where id = :id", nativeQuery = true)
	void mCounter(int id);
	
	// 효빈
	@Query(value = "select * from tip where animalId = :animalId", nativeQuery = true)
	Page<Tip> mFindKind(int animalId, Pageable pageRequest);
	
	// 재영
	
	// 주원
}