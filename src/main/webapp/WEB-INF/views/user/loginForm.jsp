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
      		<label for="Id">&nbsp; 아이디</label>
      		<input type="text" class="form-control" id="Id"  placeholder="아이디를 입력하세요" name="userId"  class="center">
    		<br>
      		<label for="pwd">&nbsp;비밀번호</label>
      		<input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요" name="pswd">
    	</div>
    	<br>
    	<div class ="text-center d-flex flex-column">
    		<div class="p-2">
    			<button type="submit" class="btn btn-success">로그인</button>
    		</div>
    		<div class="p-2">
    			<button type="submit" class="btn btn-light"  >아이디/비밀번호 찾기</button>
    		</div>
    	</div>
  	</form>
</div>
 


<%@ include file="../layout/footer.jsp"%>