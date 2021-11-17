package com.cos.petproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.petproject.domain.user.User;
import com.cos.petproject.domain.user.UserRepository;
import com.cos.petproject.handler.exception.MyAsyncNotFoundException;
import com.cos.petproject.handler.exception.MyNotFoundException;
import com.cos.petproject.util.MyAlgorithm;
import com.cos.petproject.util.SHA;
import com.cos.petproject.web.dto.user.JoinReqDto;
import com.cos.petproject.web.dto.user.LoginReqDto;
import com.cos.petproject.web.dto.user.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Transactional(rollbackFor = MyAsyncNotFoundException.class) 
	public void 회원수정(User principal, UserUpdateDto dto) {
		User userEntity = userRepository.findById(principal.getId())
				.orElseThrow(() -> new MyAsyncNotFoundException("회원정보를 찾을 수 없습니다."));
		
		userEntity.setEmail(dto.getEmail());
		userEntity.setNickname(dto.getNickname());
		userEntity.setPhone(dto.getPhone());
		userEntity.setPassword(SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256));
	}


	public User 로그인(LoginReqDto dto) {
		return userRepository.mLogin(dto.getUsername(), dto.getPassword());
	}

	@Transactional(rollbackFor = MyNotFoundException.class) 
	public void 회원가입(JoinReqDto dto) {
		// 입력받은 비밀번호 해쉬값으로 변경
		String encPassword = SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256);
		// 패스워드를 해쉬패스워드로 저장하려고
		dto.setPassword(encPassword);
		
		userRepository.save(dto.toEntity());
		
	}
}