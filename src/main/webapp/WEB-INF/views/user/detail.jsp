<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
	<style>
input[type="radio"]{width : 18px;}
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 75vh;
}

</style>



<div style="text-align:center">
<h2>회원정보</h2>
</div>
<div class="container" >
  <form action="" method="">
    <div class="form-group">
      <label for="uname">아이디</label>
      <input type="text" class="form-control" id="uname"  style="width:400px;" name="uname" required >
    </div>
     <br>
    <div class="form-group">
      <label for="pwd">비밀번호</label>
      <input type="password" class="form-control" id="pwd"  style="width:400px;" name="pswd" required>
     </div>
      <br>
    <div class="form-group">
      <label for="pwd">이름</label>
      <input type="text" class="form-control" id="name" style="width:400px;" name="name" required>
     </div>
      <br>
       <div class="form-group">
        <label for="pwd">전화번호</label>
        <br>
       <form name="phonnumber" action="" method="post">
        <input type='tel' name='phone1' / style="width:100px;">-
        <input type='tel' name='phone2' /style="width:100px;">-
        <input type='tel' name='phone3' /style="width:100px;">
        </div>
        <br>
 <div class="form-group">
      <label for="pwd">이메일</label>
      <input type="email" class="form-control" id="email"  mexlength="30"  style="width:400px;" name="email" required>
     </div>
    <br>
     <label for="pwd">성별</label><br>
    <div class="form-check-inline">
      <label class="form-check-label" for="check1">
        <input type="radio" class="form-check-input" id="man" name="gender" value="man">남성
      </label>
    </div>
    <div class="form-check-inline">
      <label class="form-check-label" for="check2">
        <input type="radio" class="form-check-input" id="woman" name="gender" value="woman">여성
      </label>
    </div>
    <br>
    <br>
     <label for="pwd">생년월일</label><br>
    <div class="from-data">
    <input type="date" value='2000-01-01'><br>
    </div>
    </br>
    <p></p>
    <button type="submit" class="btn btn-primary">회원정보 수정하기</button>
  </form>
</div>
</div>
<%@ include file="../layout/footer.jsp"%>