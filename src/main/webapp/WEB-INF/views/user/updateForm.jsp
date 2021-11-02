<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<style>

	@import url("/user_Css/updateForm.css");

</style>

<div class="container">
	<div class="d-flex justify-content-center inner-container">
		<div class="form-group input-form">
			<h1>회원정보 수정</h1>
			<form onsubmit="userUpdate(event)">
				<label for="username">아이디</label> 
				<input type="text" class="form-control" id="username" readonly> 
				<br>
				<label for="password">비밀번호</label> 
				<input type="password" class="form-control" id="password"> 
				<br>
				<label for="nickname">닉네임</label>
				<input type="text" class="form-control" id="nickname"> 
				<br>
				<label for="email">이메일</label> 
				<input type="text" class="form-control" id="email"> 
				<br>
				<label for="phone">전화번호</label> 
				<input type="text" class="form-control" id="phone">
				<br>
				<div class="d-flex justify-content-around">
					<button type="button" class="btn btn-success">수정완료</button>
					<button type="button" class="btn btn-secondary btns">취소</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script>

</script>


<%@ include file="../layout/footer.jsp"%>