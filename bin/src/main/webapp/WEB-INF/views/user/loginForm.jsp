<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<style>
	
	@import url("/user_Css/loginForm.css");
	
</style>

<div class="container">
 	<form action="/login"  method="post">
 		<div class="text-center" >
 			<h1>로그인</h1>
 		</div>
 		<br>
       	<div class="inner-container">
      		<label for="username">아이디</label>
      		<input type="text" class="form-control" id="username"  placeholder="아이디를 입력하세요" name="username"  class="center">
    		<br>
      		<label for="password">비밀번호</label>
      		<input type="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요" name="password">
    	</div>
    	<br>
    	<div class ="text-center d-flex flex-column">
    		<div class="p-2">
    			<button type="submit" class="btn btn-success">로그인</button>
    		</div>
    		<div class="p-2">
    			<button type="button" class="btn btn-light" onclick="location.href='/user/idFind'">아이디/비밀번호 찾기</button>
    		</div>
    	</div>
  	</form>
</div>
 


<%@ include file="../layout/footer.jsp"%>