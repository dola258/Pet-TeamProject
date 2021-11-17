package com.cos.petproject.service.board;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cos.petproject.domain.animal.Animal;
import com.cos.petproject.domain.animal.AnimalRepository;
import com.cos.petproject.domain.boast.Boast;
import com.cos.petproject.domain.comment.CommentRepository;
import com.cos.petproject.domain.qna.Qna;
import com.cos.petproject.domain.qna.QnaRepository;
import com.cos.petproject.domain.user.User;
import com.cos.petproject.handler.exception.MyAsyncNotFoundException;
import com.cos.petproject.handler.exception.MyNotFoundException;
import com.cos.petproject.web.dto.board.BoastSaveReqDto;
import com.cos.petproject.web.dto.board.QnaSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QnaService {
	
	private final QnaRepository qnaRepository;
	private final AnimalRepository animalRepository;
	private final CommentRepository commentRepository;
	
	
	@Transactional(rollbackOn = MyNotFoundException.class)
	public void 게시글등록(QnaSaveReqDto dto, int animalId, User principal) {
		// 글 작성
		qnaRepository.mSave(dto.getContent(), dto.getTitle(), animalId, principal);
	}
	
	
	@Transactional(rollbackOn = MyAsyncNotFoundException.class)
	public void 게시글수정(User principal, int id, int animalId, QnaSaveReqDto dto) {
		Qna qnaEntity = qnaRepository.findById(id).orElseThrow(() -> new MyAsyncNotFoundException("해당 게시글을 찾을 수 없습니다"));

		if (principal.getId() != qnaEntity.getUser().getId()) {
			throw new MyAsyncNotFoundException("해당 게시물의 권한이 없습니다");
		}
		
		Animal animal = animalRepository.getById(animalId);
		
		Qna qna = dto.toEntity(principal);
		qna.setUser(principal);
		qna.setId(id);
		qna.setAnimal(animal);
		qna.setCounter(qnaEntity.getCounter());
		qna.setCreatedAt(LocalDateTime.now());
		qnaRepository.save(qna);
	}
	
	@Transactional(rollbackOn = MyAsyncNotFoundException.class)
	public void 게시글삭제(User principal, int id) {
		// 권한이 있는 사람만 함수 접근 가능(principal.id == {id})
		Qna qnaEntity = qnaRepository.findById(id).orElseThrow(() -> new MyAsyncNotFoundException("해당글을 찾을 수 없습니다."));
		if (principal.getId() != qnaEntity.getUser().getId() && !principal.getAuthority().equals("admin")) {
			throw new MyAsyncNotFoundException("해당글을 삭제할 권한이 없습니다.");
		}

		try {
			commentRepository.mdeleteById(principal.getId());
			qnaRepository.deleteById(id); // 오류 발생??? (id가 없으면)
		} catch (Exception e) {
			throw new MyAsyncNotFoundException(id + "를 찾을 수 없어서 삭제할 수 없어요.");
		}
	}
	
	
	public Qna 게시글수정페이지이동(int id) {
		Qna qnaEntity = qnaRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException(id + " 페이지를 찾을 수 없습니다."));

		return qnaEntity;
	}
	
	
	public Qna 게시글상세보기(int id) {
		// id로 게시글 찾기
		Qna qnaEntity = qnaRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException(id + " 페이지를 찾을 수 없습니다."));

		return qnaEntity;
	}
	

	public Page<Qna> 게시글목록보기(int page, int animalId) {
		Pageable pageRequest = PageRequest.of(page, 10, Sort.by("id").descending());
		Page<Qna> qnaEntity = qnaRepository.mFindKind(animalId, pageRequest);

		return qnaEntity;
	}
	
}
