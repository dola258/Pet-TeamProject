<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<div class="container">
	<div class="d-flex justify-content-center"
		style="padding-top: 20px; padding-bottom: 20px;">
		<div class="form-group " style="width: 300px">
			<h1>회원정보 수정</h1>
			<label for="username">아이디</label> <input type="text"
				class="form-control" id="username" readonly> <label
				for="password">비밀번호</label> <input type="password"
				class="form-control" id="password"> <label for="nickname">닉네임</label>
			<input type="text" class="form-control" id="nickname"> <label
				for="email">이메일</label> <input type="text" class="form-control"
				id="email"> <label for="phone">전화번호</label> <input
				type="text" class="form-control" id="phone"><br>
			<div class="d-flex justify-content-center">
				<button type="button" class="btn btn-success">회원정보 수정</button>
			</div>
		</div>
	</div>
</div>




<%@ include file="../layout/footer.jsp"%>