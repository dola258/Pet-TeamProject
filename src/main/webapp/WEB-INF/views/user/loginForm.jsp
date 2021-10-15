<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>


<div class="container">
 <form action="/login"  method="post">
 <img src="cinqueterre.jpg" class="rounded-circle" alt="Cinque Terre" width="304" height="236"> 
 <div class="text-center">
 <h2>login</h2>
 </div>
 <div class="form-group">
      <label for="Id">아이디:</label>
      <input type="text" class="form-control" id="Id" placeholder="아이디를 입력하세요" name="userId">
    </div>
    <div class="form-group">
      <label for="pwd">비밀번호:</label>
      <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요" name="pswd">
    </div>
    <br>
    <button type="submit" class="btn btn-primary"  >로그인</button>
  </form>
</div>
 


<%@ include file="../layout/footer.jsp"%>