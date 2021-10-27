<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<style>

	@import url("/user/joinForm.css")

</style>

<div style="text-align: center">
	<h2>회원가입</h2>
</div>
<div class="container">
	<form action="" method="">
		<div class="form-group">
			<label for="uname">아이디</label> 
			<input type="text" class="form-control inputs" id="uname" placeholder="아이디를 입력하세요" name="uname" required>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">비밀번호</label> 
			<input type="password" class="form-control inputs" id="pwd" placeholder="패스워드를 입력하세요" name="pswd" required>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">이름</label> 
			<input type="text" class="form-control inputs" id="name" placeholder="이름을 입력하세요" name="name" required>
		</div>
		<br>
		<div class="form-group">
			<label for="nickname">닉네임</label> 
			<input type="text" class="form-control inputs" id="nickname" placeholder="닉네임을 입력하세요" name="nickname" required>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">전화번호(숫자만 입력해주세요)</label> 
			<input type="text" pattern="[0-9]+" class="form-control inputs" id="phone"	placeholder="전화번호를 입력하세요" name="phone" required>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">이메일</label>
			<div class="d-flex justify-content-between">
				<input type="email" class="form-control e-input" id="email" placeholder="이메일을 입력하세요" name="email" required>
				<button type="button" class="btn btn-outline-info">인증메일 받기</button>
			</div>
		</div>
		<br>
		<div class="form-group">
			<label for="">인증 번호</label>
			<div class="d-flex justify-content-between"> 
				<input type="text" class="form-control e-input" id="" name="" required>
				<button type="button" class="btn btn-outline-info e-btn">확인</button>
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
				<label for="pwd">생년월일</label><br>
			</div>
			<div class="from-data flex-fill">
				<input type="date" ><br>
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