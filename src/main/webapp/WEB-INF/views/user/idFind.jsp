<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<style>

	@import url("/user_Css/idfind.css");

</style>
<div class="container">
	<div class="d-flex justify-content-center">
		<div class="d-flex flex-column inner-container">
			<div>
				<button type="button" class="btn btn-outline-success active" data-bs-toggle="button" aria-pressed="true" nclick="location.href='#'">아이디 찾기</button>
				<button type="button" class="btn btn-outline-warning" onclick="location.href='#'">비밀번호 변경</button>
				<div class="border border-success"></div>
			</div>
			<div>
				<form onsubmit="idFind(event)">
				<div class="mb-3 mt-3 d-flex justify-content-center ">
					<div class="d-flex flex-column">
						<label for="name">이름</label> 
						<input type="text" class="form-control inputs" name="name" id="name" placeholder="이름을 입력해주세요." required="required">
					</div>
				</div>
				<br>
				<div class="mb-3 mt-3 d-flex justify-content-center">
					<div class="inputs">
						<label for="birth">생년월일</label>&emsp;
						<input type="date" name="birth" id="birth" required="required">
					</div>
				</div>
				<br>
				<div class="mb-3 d-flex justify-content-center ">
					<div class="d-flex flex-column">
						<label for="email">이메일</label> 
						<input type="email" class="form-control inputs" name="email" id="email" placeholder="등록된 이메일을 입력해주세요"	required="required">
					</div>
				</div>
				<p style="text-align: center;">등록된 이메일 주소로 확인링크가 전송됩니다.</p>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-success btns">찾기</button>
					<button type="button" class="btn btn-secondary btns btn-cancel" onclick="location.href='#'">취소</button>
				</div>
				</form>
			</div>
		</div>
		<!-- The Modal -->
		<div class="modal fade" id="idFindModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">아이디 찾기 완료</h4>
						<!-- <button type="button" class="btn-close" data-bs-dismiss="modal"></button>  -->
					</div>

					<!-- Modal body -->
					<div class="modal-body">${userEntity.username }</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-bs-dismiss="modal" onclick="window.location.reload()">닫기</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	async function idFind() {
		event.preventDefault();
		  	
		
		$("#idFindModal").modal('show');

	}
</script>

<%@ include file="../layout/footer.jsp"%>