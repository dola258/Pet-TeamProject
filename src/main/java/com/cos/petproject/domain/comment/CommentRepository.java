package com.cos.petproject.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	// 댓글 삭제
	@Query(value = "delete from comment where UserId = :userId", nativeQuery = true)
	void mdeleteById(int userId);
}
