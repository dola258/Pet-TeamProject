package com.cos.petproject.service.board;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cos.petproject.domain.boast.Boast;
import com.cos.petproject.domain.notice.Notice;
import com.cos.petproject.domain.notice.NoticeRepository;
import com.cos.petproject.domain.user.User;
import com.cos.petproject.handler.exception.MyAsyncNotFoundException;
import com.cos.petproject.handler.exception.MyNotFoundException;
import com.cos.petproject.web.dto.board.NoticeSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeService {

	private final NoticeRepository noticeRepository;
	
	@Transactional(rollbackOn = MyNotFoundException.class)
	public void 게시글등록(NoticeSaveReqDto dto, User principal) {
		// 글 작성
		noticeRepository.mSave(dto.getContent(), dto.getTitle(), principal);

	}
	
	
	@Transactional(rollbackOn = MyAsyncNotFoundException.class)
	public void 게시글수정(User principal, int id, NoticeSaveReqDto dto) {
		Notice noticeEntity = noticeRepository.findById(id)
				.orElseThrow(()->new MyAsyncNotFoundException("해당 게시글을 찾을 수 없습니다"));
		
		if(principal.getId() != noticeEntity.getUser().getId()) {
			throw new MyAsyncNotFoundException("해당 게시물의 권한이 없습니다");
		}
		
		
		Notice notice = dto.toEntity(principal);
		notice.setUser(principal);
		notice.setId(id);
		notice.setCounter(noticeEntity.getCounter());
		notice.setCreatedAt(LocalDateTime.now());
		noticeRepository.save(notice);			
		
	}
	
	@Transactional(rollbackOn = MyAsyncNotFoundException.class)
	public void 게시글삭제(User principal, int id) {
		// 권한이 있는 사람만 함수 접근 가능(principal.id == {id})
		Notice noticeEntity = noticeRepository.findById(id).orElseThrow(() -> new MyAsyncNotFoundException("해당글을 찾을 수 없습니다."));
		if (principal.getId() != noticeEntity.getUser().getId()) {
			throw new MyAsyncNotFoundException("해당글을 삭제할 권한이 없습니다.");
		}

		try {
			noticeRepository.deleteById(id); // 오류 발생??? (id가 없으면)
		} catch (Exception e) {
			throw new MyAsyncNotFoundException(id + "를 찾을 수 없어서 삭제할 수 없어요.");
		}
	}
	
	
	public Notice 게시글수정페이지이동(int id) {
		
		Notice noticeEntity = noticeRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException(id + " 페이지를 찾을 수 없습니다."));


		return noticeEntity;
	}
	
	
	public Notice 게시글상세보기(int id) {
		// id로 게시글 찾기
		Notice noticeEntity = noticeRepository.findById(id)
				.orElseThrow(() -> new MyNotFoundException(id + " 페이지를 찾을 수 없습니다."));
		
		return noticeEntity;
	}
	

	public Page<Notice> 게시글목록보기(int page) {
		Pageable pageRequest = PageRequest.of(page, 10, Sort.by("id").descending());
		Page<Notice> noticeEntity = noticeRepository.findAll(pageRequest);

		return noticeEntity;
	}
	
	
}
