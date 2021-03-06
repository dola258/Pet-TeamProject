package com.cos.petproject.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.petproject.domain.boast.Boast;
import com.cos.petproject.domain.boast.BoastRepository;
import com.cos.petproject.domain.comment.Comment;
import com.cos.petproject.domain.comment.CommentRepository;
import com.cos.petproject.domain.qna.Qna;
import com.cos.petproject.domain.qna.QnaRepository;
import com.cos.petproject.domain.tip.Tip;
import com.cos.petproject.domain.tip.TipRepository;
import com.cos.petproject.domain.user.User;
import com.cos.petproject.handler.exception.MyAsyncNotFoundException;
import com.cos.petproject.handler.exception.MyNotFoundException;
import com.cos.petproject.web.dto.CommentSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {

	private final CommentRepository commentRepository;
	private final BoastRepository boastRepository;
	private final QnaRepository qnaRepository;
	private final TipRepository tipRepository;
	
	
	// 댓글 등록--------------------------------------------------------------------------------------------
	@Transactional(rollbackFor = MyNotFoundException.class) 
	public void 자랑하기댓글등록(int id, CommentSaveReqDto dto, User principal) {

		Boast boastEntity = boastRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException("해당 게시글을 찾을 수 없습니다."));
		
		Comment comment = new Comment();
		
		comment.setContent(dto.getContent());
		comment.setUser(principal);
		comment.setBoast(boastEntity);
		
		// 4. save하기
		commentRepository.save(comment);
	}
	@Transactional(rollbackFor = MyNotFoundException.class) 
	public void QnA댓글등록(int id, CommentSaveReqDto dto, User principal) {
		
		Qna qnaEntity = qnaRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException("해당 게시글을 찾을 수 없습니다."));
		
		Comment comment = new Comment();
		
		comment.setContent(dto.getContent());
		comment.setUser(principal);
		comment.setQna(qnaEntity);
		
		// 4. save하기
		commentRepository.save(comment);
	}
	@Transactional(rollbackFor = MyNotFoundException.class) 
	public void 꿀팁댓글등록(int id, CommentSaveReqDto dto, User principal) {
		
		Tip tipEntity = tipRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException("해당 게시글을 찾을 수 없습니다."));
		
		Comment comment = new Comment();
		
		comment.setContent(dto.getContent());
		comment.setUser(principal);
		comment.setTip(tipEntity);
		
		// 4. save하기
		commentRepository.save(comment);
	}


	// 댓글 삭제--------------------------------------------------------------------------------------------
	@Transactional(rollbackFor = MyAsyncNotFoundException.class) 
	public void 댓글삭제(int id, User principal) {

		// 영속성 컨텍스트
		Comment commentEntity = commentRepository.findById(id)
				.orElseThrow(() -> new MyAsyncNotFoundException("없는 댓글번호입니다."));
		
		if(principal.getId() != commentEntity.getUser().getId() ) {
			throw new MyAsyncNotFoundException("해당 댓글을 삭제할 수 없는 유저입니다.");
		}
		
		commentRepository.deleteById(id);
	}


}
