package com.cos.petproject.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
	
}
