<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<style type="text/css" >
	
	@import url("/user_Css/joinForm.css");

</style>

<div class="cate">
	<h2>회원가입</h2>
</div>
<div class="container">
	<form action="/join" method="post">
		<div class="form-group">
			<label for="username">아이디</label> 
			<input type="text" class="form-control inputs" placeholder="아이디를 입력하세요" name="username" required>
		</div>
		<br>
		<div class="form-group">
			<label for="password">비밀번호</label> 
			<input type="password" class="form-control inputs" placeholder="패스워드를 입력하세요" name="password" required>
		</div>
		<br>
		<div class="form-group">
			<label for="name">이름</label> 
			<input type="text" class="form-control inputs" placeholder="이름을 입력하세요" name="name" required>
		</div>
		<br>
		<div class="form-group">
			<label for="nickname">닉네임</label> 
			<input type="text" class="form-control inputs" placeholder="닉네임을 입력하세요" name="nickname" required>
		</div>
		<br>
		<div class="form-group">
			<label for="phone">전화번호(숫자만 입력해주세요)</label> 
			<input type="text" pattern="[0-9]+" class="form-control inputs" placeholder="전화번호를 입력하세요" name="phone" required>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">이메일</label>
			<div class="d-flex justify-content-between">
				<input type="email" class="form-control e-input" id="email" placeholder="이메일을 입력하세요" name="email" required>
				<button type="button" class="btn btn-outline-info" id= "AuthEmailButton" onclick="emailTest();">인증메일 받기</button>
			</div>
		</div>
		<br>
		<div class="form-group">
			<label for="">인증 번호</label>
			<div class="d-flex justify-content-between"> 
				<input type="text" class="form-control e-input" id="autoCode" required>
				<button type="button" class="btn btn-outline-info e-btn"  id="authChk"  onclick="authChkT();">확인</button>
			</div>
		</div>
		<br>
		<div class="d-flex">
			<div class="flex-fill">
				<label for="pwd">성별</label>
			</div>
			<div class="form-check-inline flex-fill">
				<label class="form-check-label" for="check1"> 
					<input type="radio" class="form-check-input" id="man" name="gender" value="man">남성
				</label>
			</div>
			<div class="form-check-inline flex-fill">
				<label class="form-check-label" for="check2"> 
					<input type="radio" class="form-check-input" id="woman" name="gender" value="woman">여성
				</label>
			</div>
		</div>
		<br>
		<div class="d-flex">
			<div class="flex-fill">
				<label for="birth">생년월일</label><br>
			</div>
			<div class="from-data flex-fill">
				<input type="date" name="birth"><br>
			</div>
		</div>
		<br>
		<br>
		<div class="d-flex justify-content-center">
			<button type="submit" class="btn btn-success">회원가입 완료</button>
		</div>
	</form>
</div>


<%@ include file="../layout/footer.jsp"%>