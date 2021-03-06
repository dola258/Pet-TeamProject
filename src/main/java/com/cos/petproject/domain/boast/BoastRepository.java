package com.cos.petproject.domain.boast;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	@Query(value = "select * from boast where animalId = :animalId", nativeQuery = true)
	Page<Boast> mFindKind(int animalId, Pageable pageRequest);
	
	// 메인페이지 게시글 조회수 상위 3개
	@Query(value = "SELECT  * from boast ORDER BY counter DESC LIMIT 3;", nativeQuery = true)
	List<Boast> mMain();
	
	// 재영
	
	// 주원
}
