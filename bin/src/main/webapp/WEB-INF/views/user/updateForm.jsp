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
			<form onsubmit="userUpdate(event, ${principal.id})">
				<label for="username">아이디</label> 
				<input type="text" class="form-control" id="username" value="${principal.username }" readonly> 
				<br> 
				<label for="password">비밀번호</label> 
				<input type="password" class="form-control" id="password"> 
				<br> 
				<label for="nickname">닉네임</label> 
				<input type="text" class="form-control" id="nickname"> 
				<br>
				<div class="form-group">
					<label for="pwd">이메일</label>
					<div class="d-flex justify-content-between">
						<input type="email" class="form-control e-input" id="email" placeholder="이메일을 입력하세요" name="email" required>
						<button type="button" class="btn btn-outline-info" id="AuthEmailButton" onclick="emailTest();">인증메일 받기</button>
					</div>
				</div>
				<br>
				<div class="form-group">
					<label for="">인증 번호</label>
					<div class="d-flex justify-content-between">
						<input type="text" class="form-control e-input" id="authCode" name="authKey" required>
						<button type="button" class="btn btn-outline-info e-btn" id="authChk" onclick="authChkT();">확인</button>
					</div>
					<div class="text-center" id="mail_check_input_box_warn"></div>
				</div>
				<br> <label for="phone">전화번호</label> <input type="text"
					class="form-control" id="phone"> <br>
				<div class="d-flex justify-content-around">
					<button type="submit" class="btn btn-success">수정완료</button>
					<button type="button" class="btn btn-secondary btns">취소</button>
				</div>
			</form>
		</div>
	</div>
</div>


<script>
async function userUpdate(event, id){ 
	
	event.preventDefault();
	
	let userUpdateDto = {
		   password: document.querySelector("#password").value,
		   nickname: document.querySelector("#nickname").value,
		   email: document.querySelector("#email").value,
		   phone: document.querySelector("#phone").value,
		   authKey: document.querySelector("#authCode").value
   	};
	

	let response = await fetch("http://localhost:8080/api/user/"+id, {
		method: "put",
		body: JSON.stringify(userUpdateDto),
		headers: {
			"Content-Type": "application/json; charset=utf-8"
		}
	});
	
	let parseResponse = await response.json();
	
	console.log(parseResponse);
	
	if(parseResponse.code == 1){
		alert("업데이트 성공");
		location.href = "/user/detail/"+id;
	}else{
		alert("업데이트 실패 : "+parseResponse.msg);
	} 
}
</script>

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
			email: document.querySelector("#email").value
	}
	
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