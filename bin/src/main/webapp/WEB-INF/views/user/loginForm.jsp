<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>


<div class="container">
 <form action="/login"  method="post">
 <div class="text-center" >
 <h1>Login</h1>
 </div>
 <br>
       <div style="width: 30%; float:none; margin:0 auto" >
      <label for="Id">&nbsp; 아이디:</label>
      <input type="text" class="form-control" id="Id"  placeholder="아이디를 입력하세요" name="userId"  class="center">
    <br>
      <label for="pwd">&nbsp;비밀번호:</label>
      <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요" name="pswd">
    </div>
    <br>
    <div class ="text-center">
    <button type="submit" class="btn btn-success"  >로그인</button>
    </div>
  </form>
</div>
 


<%@ include file="../layout/footer.jsp"%>