
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<style>
input[type="radio"] {
	width: 18px;
}

.container {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 75vh;
}
</style>



<div style="text-align: center">
	<h2>회원가입</h2>
</div>
<div class="container">
	<form action="" method="">
		<div class="form-group">
			<label for="uname">아이디</label> <input type="text" class="form-control" id="uname" placeholder="아이디를 입력하세요" style="width: 400px;" name="uname" required>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">비밀번호</label> 
			<input type="password" class="form-control" id="pwd" placeholder="패스워드를 입력하세요" style="width: 400px;" name="pswd" required>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">이름</label> 
			<input type="text" class="form-control" id="name" placeholder="이름을 입력하세요" style="width: 400px;" name="name" required>
		</div>
		<br>
		<div class="form-group">
			<label for="nickname">닉네임</label> 
			<input type="text" class="form-control" id="nickname" placeholder="닉네임을 입력하세요" style="width: 400px;" name="nickname" required>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">전화번호(숫자만 입력해주세요)</label> 
			<input type="text" pattern="[0-9]+" class="form-control" id="phone"	placeholder="전화번호를 입력하세요" style="width: 400px;" name="phone" required>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">이메일</label>
			<div class="d-flex justify-content-between">
				<input type="email" class="form-control" id="email" mexlength="30" placeholder="이메일을 입력하세요" style="width: 250px;" name="email" required>
				<button type="button" class="btn btn-outline-info">인증메일 받기</button>
			</div>
		</div>
		<br>
		<div class="form-group">
			<label for="">인증 번호</label>
			<div class="d-flex justify-content-between"> 
				<input type="text" class="form-control" id="" style="width: 250px;" name="" required>
				<button type="button" class="btn btn-outline-info" style="width: 127.63px;">확인</button>
			</div>
		</div>
		<br>
		<div class="d-flex">
			<div class="flex-fill">
				<label for="pwd">성별</label>
			</div>
			<div class="form-check-inline flex-fill">
				<label class="form-check-label" for="check1"> <input
					type="radio" class="form-check-input" id="man" name="gender"
					value="man">남성
				</label>
			</div>
			<div class="form-check-inline flex-fill">
				<label class="form-check-label" for="check2"> <input
					type="radio" class="form-check-input" id="woman" name="gender"
					value="woman">여성
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