package com.cos.petproject.domain.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.petproject.domain.authMail.AuthEmail;

public interface UserRepository extends JpaRepository<User, Integer> {
	// 로그인
	@Query(value = "select * from user where username = :username and password = :password", nativeQuery = true)
	User mLogin(String username, String password);
	
	// 아이디 찾기
	@Query(value = "select * from user where name = :name and birth = :birth and email = :email", nativeQuery = true)
	User mIdFind(String name, String birth, String email);
	
	// 비밀번호 변경
	@Query(value = "update user set password = :password where id = :id", nativeQuery = true)
	User mPwChange(int id, String password);
	
	// 성준
	// 회원 목록 조회 (만 나이 X)
	@Query(value = "SELECT id, authority, PASSWORD, nickname, NAME, username, if(gender = 'man', '남자', '여자') AS gender, ROUND((TO_DAYS(NOW()) - TO_DAYS(DATE_FORMAT(birth, '%Y-%m-%d'))) / 365) AS birth, phone, email FROM user;", nativeQuery = true)
	Optional<List<User>> mSelectUser();
	
	// 재영
	@Query(value = "select * from user where username = :username and name = :name and birth = :birth and email = :email", nativeQuery = true)
	User mPWFind(String username, String name, String birth, String email);
	
	// 효빈
	@Query(value = "select username from user where username = :username", nativeQuery = true)
	String mIdCheck(String username);
	@Query(value = "select phone from user where phone = :phone", nativeQuery = true)
	String mPhoneCheck(String phone);
	@Query(value = "select email from user where email = :email", nativeQuery = true)
	String mEmailCheck(String email);
	// DB에 저장된 인증키불러오기 - 회원가입 클릭했을때 적은 인증키로 찾아보기
	@Query(value = "SELECT DISTINCT authKey from authemail where authKey = :authKey", nativeQuery = true)
	String mFindAuthKey(String authKey);

	// 주원
	
	
	
}
