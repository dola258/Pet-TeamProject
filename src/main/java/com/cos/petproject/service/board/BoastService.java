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
import com.cos.petproject.domain.boast.BoastRepository;
import com.cos.petproject.domain.comment.CommentRepository;
import com.cos.petproject.domain.user.User;
import com.cos.petproject.handler.exception.MyAsyncNotFoundException;
import com.cos.petproject.handler.exception.MyNotFoundException;
import com.cos.petproject.web.dto.board.BoastSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoastService {
	
	private final BoastRepository boastRepository;
	private final AnimalRepository animalRepository;
	private final CommentRepository commentRepository;
	
	
	@Transactional(rollbackOn = MyNotFoundException.class)
	public void 게시글등록(BoastSaveReqDto dto, int animalId, User principal) {
		// 글 작성
		boastRepository.mSave(dto.getContent(), dto.getTitle(), animalId, principal);

	}
	
	
	@Transactional(rollbackOn = MyAsyncNotFoundException.class)
	public void 게시글수정(User principal, int id, int animalId, BoastSaveReqDto dto) {
		Boast boastEntity = boastRepository.findById(id)
				.orElseThrow(() -> new MyAsyncNotFoundException("해당 게시글을 찾을 수 없습니다"));

		if (principal.getId() != boastEntity.getUser().getId()) {
			throw new MyAsyncNotFoundException("해당 게시물의 권한이 없습니다");
		}
		Animal animal = animalRepository.getById(animalId);
		
		dto.setContent(dto.getContent().replaceAll("<p>", ""));
		dto.setContent(dto.getContent().replaceAll("</p>", ""));
		
		Boast boast = dto.toEntity(principal);
		boast.setUser(principal);
		
		boast.setId(id);
		boast.setAnimal(animal);
		boast.setCounter(boastEntity.getCounter());
		boast.setCreatedAt(LocalDateTime.now());
		boastRepository.save(boast);
	}
	
	@Transactional(rollbackOn = MyAsyncNotFoundException.class)
	public void 게시글삭제(User principal, int id) {
		// 권한이 있는 사람만 함수 접근 가능(principal.id == {id})
		Boast boastEntity = boastRepository.findById(id)
				.orElseThrow(() -> new MyAsyncNotFoundException("해당글을 찾을 수 없습니다."));
		if (principal.getId() != boastEntity.getUser().getId() && !principal.getAuthority().equals("admin")) {
			throw new MyAsyncNotFoundException("해당글을 삭제할 권한이 없습니다.");
		}

		try {
			commentRepository.mdeleteById(principal.getId());
			boastRepository.deleteById(id); // 오류 발생??? (id가 없으면)
		} catch (Exception e) {
			throw new MyAsyncNotFoundException(id + "를 찾을 수 없어서 삭제할 수 없어요.");
		}
	}
	
	
	public Boast 게시글수정페이지이동(int id) {
		Boast boastEntity = boastRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException(id + " 페이지를 찾을 수 없습니다."));

		return boastEntity;
	}
	
	
	public Boast 게시글상세보기(int id) {
		// id로 게시글 찾기
		Boast boastEntity = boastRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException(id + " 페이지를 찾을 수 없습니다."));
		
		return boastEntity;
	}
	

	public Page<Boast> 게시글목록보기(int page, int animalId) {
		Pageable pageRequest = PageRequest.of(page, 10, Sort.by("id").descending());
		Page<Boast> boastEntity = boastRepository.mFindKind(animalId, pageRequest);

		return boastEntity;
	}
	
}
