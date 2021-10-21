
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
	<h2>회원정보</h2>
</div>
<div class="container">
	<form action="" method="">
		<div class="form-group">
			<label for="uname">아이디</label> 
			<input type="text" class="form-control" id="uname" style="width: 400px;" name="uname" readonly>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">비밀번호</label> 
			<input type="password" class="form-control" id="pwd" style="width: 400px;" name="pswd" readonly>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">이름</label> 
			<input type="text" class="form-control" id="name" style="width: 400px;" name="name" readonly>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">전화번호</label> 
			<input type="text" class="form-control"	id="phone" style="width: 400px;" name="phone" readonly>
		</div>
		<br>
		<div class="form-group">
			<label for="email">이메일</label> 
			<input type="email" class="form-control" id="email" mexlength="30" style="width: 400px;" name="email" readonly>
		</div>
		<br> 
		<div class="form-group">
			<label for="gender">성별</label> 
			<input type="text" class="form-control" id="gender" mexlength="30" style="width: 400px;" name="gender" readonly>
		</div>
		<br>
		<div class="form-group">
			<label for="birth">생넌월일</label> 
			<input type="text" class="form-control" id="birth" mexlength="30" style="width: 400px;" name="birth"  readonly>
		</div>
		<br>
		<div class="d-flex justify-content-around">
			<button type="submit" class="btn btn-success">수정하기</button>
			<button type="button" class="btn btn-secondary">뒤로가기</button>
		</div>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>