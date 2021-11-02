<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<style type="text/css" >
	
	@import url("/user_Css/joinForm.css");

</style>

<div class="cate">
	<h2>회원가입</h2>
</div>
<div class="container">
	<form action="/join" method="post">
		<div class="form-group">
			<label for="username">아이디</label> 
			<input type="text" class="form-control inputs" placeholder="아이디를 입력하세요" name="username" required>
		</div>
		<br>
		<div class="form-group">
			<label for="password">비밀번호</label> 
			<input type="password" class="form-control inputs" placeholder="패스워드를 입력하세요" name="password" required>
		</div>
		<br>
		<div class="form-group">
			<label for="name">이름</label> 
			<input type="text" class="form-control inputs" placeholder="이름을 입력하세요" name="name" required>
		</div>
		<br>
		<div class="form-group">
			<label for="nickname">닉네임</label> 
			<input type="text" class="form-control inputs" placeholder="닉네임을 입력하세요" name="nickname" required>
		</div>
		<br>
		<div class="form-group">
			<label for="phone">전화번호(숫자만 입력해주세요)</label> 
			<input type="text" pattern="[0-9]+" class="form-control inputs" placeholder="전화번호를 입력하세요" name="phone" required>
		</div>
		<br>
		<div class="form-group">
			<label for="pwd">이메일</label>
			<div class="d-flex justify-content-between">
				<input type="email" class="form-control e-input" id="email" placeholder="이메일을 입력하세요" name="email" required>
				<button type="button" class="btn btn-outline-info" id= "AuthEmailButton" onclick="emailTest();">인증메일 받기</button>
			</div>
		</div>
		<br>
		<div class="form-group">
			<label for="">인증 번호</label>
			<div class="d-flex justify-content-between"> 
				<input type="text" class="form-control e-input" id="authCode" name="authKey" required>
				<button type="button" class="btn btn-outline-info e-btn"  id="authChk"  onclick="authChkT();">확인</button>
			</div>
			<div class="text-center" id="mail_check_input_box_warn"></div>
		</div>
		<br>
		<div class="d-flex">
			<div class="flex-fill">
				<label for="pwd">성별</label>
			</div>
			<div class="form-check-inline flex-fill">
				<label class="form-check-label" for="check1"> 
					<input type="radio" class="form-check-input" id="man" name="gender" value="man">남성
				</label>
			</div>
			<div class="form-check-inline flex-fill">
				<label class="form-check-label" for="check2"> 
					<input type="radio" class="form-check-input" id="woman" name="gender" value="woman">여성
				</label>
			</div>
		</div>
		<br>
		<div class="d-flex">
			<div class="flex-fill">
				<label for="birth">생년월일</label><br>
			</div>
			<div class="from-data flex-fill">
				<input type="date" name="birth"><br>
			</div>
		</div>
		<br>
		<br>
		<div class="d-flex justify-content-center">
			<button type="submit" class="btn btn-success">회원가입 완료</button>
		</div>
	</form>
</div>

<script>
var authkey = null;

	async function emailTest() {
		console.log(document.querySelector("#email").value);
		
		let EmailReqDto = {
				email: document.querySelector("#email").value,
		};
		
		let response = await fetch("http://localhost:8080/user/email/join", {
			method: "post",
			body: JSON.stringify(EmailReqDto),
			headers: {
				"Content-Type": "application/json; charset=utf-8"
			}
		});
		
		let parseResponse = await response.json();
		console.log(parseResponse);
		
			if(parseResponse.code == 1) { // ajax는 자바스크립트에서 분기 시켜줘야 한다
				alert(" 인증번호가 이메일로 전송되었습니다.");
				goTimer();
				//location.href="/";
			} else {
				// 이 부분에서 msg 출력으로 변경됨
				alert(parseResponse.errors[0].defaultMessage);
			}
		
	};
	
	var timer = null;
	var isRunning = false;


    function goTimer(){
    	
    	var display = $('.time');
    	
    	// 유효시간 설정
    	var leftSec = 180;
    	
    	// 버튼 클릭 시 시간 연장
    	if(!isRunning) {
			startTimer(leftSec, display);
    	};
   	};


	    
	async function startTimer(count, display) {
           
   		var minutes, seconds;
           timer = await setInterval(function () {
           minutes = parseInt(count / 60, 10);
           seconds = parseInt(count % 60, 10);
    
           minutes = minutes < 10 ? "0" + minutes : minutes;
           seconds = seconds < 10 ? "0" + seconds : seconds;
    
           display.html(minutes + ":" + seconds);
    
           // 타이머 끝
           if (--count < 0) {
   	           clearInterval(timer);
   	           //alert("시간초과");
   	           display.html("시간초과");
   	           $('#AuthEmailButton').attr("disabled","disabled");
   	           $('#AuthEmailButton').attr("class","btn btn-outline-danger");
         }
       }, 1000);
            isRunning = true;
	}
	
</script>

<script>
	
	// 인증번호 비교
	async function authChkT() {

		var checkResult = $("#mail_check_input_box_warn");
		
		console.log(document.querySelector("#authCode").value);
		let AuthEmailReqDto = {
				authKey: document.querySelector("#authCode").value,
				email: document.querySelector("#email").value,
		};
		
		let response = await fetch("http://localhost:8080/user/email/check", {
			method: "post",
			body: JSON.stringify(AuthEmailReqDto),
			headers: {
				"Content-Type": "application/json; charset=utf-8"
			}
		});
		
		let parseResponse = await response.json();
		
			if(parseResponse.code == 1) { // ajax는 자바스크립트에서 분기 시켜줘야 한다
		        checkResult.html("인증번호가 일치합니다.");
		        checkResult.attr("class", "text-success");
		        $("#authCode").attr("readonly", "readonly")
		        $("#authChk").attr("disabled", "disabled")
			} else {
				console.log(parseResponse.message);
		        checkResult.html("인증번호를 다시 확인해주세요.");
		        checkResult.attr("class", "text-danger");
			}
		
	};
	
</script>


<%@ include file="../layout/footer.jsp"%>