
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<style>

	@import url("/user_Css/detail.css");
	
</style>

<div style="text-align: center">
	<h2>회원정보</h2>
</div>
<div class="container">
	<form action="" method="">
		<div class="inner-containers">
		<div class="form-group">
			<label for="uname">아이디</label> 
			<input type="text" class="form-control inputs" id="uname" name="uname" value="${principal.username }" readonly>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">이름</label> 
			<input type="text" class="form-control inputs" id="name" name="name" value="${principal.name }" readonly>
		</div>
		<br>
		<div class="form-group">
			<label for="nick">닉네임</label> 
			<input type="text" class="form-control inputs" id="nick" name="nick" value="${principal.nickname }" readonly>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">전화번호</label> 
			<input type="text" class="form-control inputs"	id="phone" name="phone" value="${principal.phone }" readonly>
		</div>
		<br>
		<div class="form-group">
			<label for="email">이메일</label> 
			<input type="email" class="form-control inputs" id="email" name="email" value="${principal.email }" readonly>
		</div>
		<br> 
		<div class="form-group">
			<label for="gender">성별</label> 
			<input type="text" class="form-control inputs" id="gender" name="gender" value="${principal.gender }" readonly>
		</div>
		<br>
		<div class="form-group">
			<label for="birth">생넌월일</label> 
			<input type="text" class="form-control inputs" id="birth" name="birth" value="${principal.birth }" readonly>
		</div>
		<br>
		<div class="d-flex justify-content-around">
			<button type="submit" class="btn btn-success">수정하기</button>
			<button type="button" class="btn btn-secondary">뒤로가기</button>
		</div>
		</div>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>