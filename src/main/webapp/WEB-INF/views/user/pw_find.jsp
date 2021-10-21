<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<div class="container">
	<div class="d-flex justify-content-center">
		<div class="d-flex flex-column" style="width:600px;">
			<div>
				<button type="button" class="btn btn-outline-success"  onclick="location.href='#'">아이디 찾기</button>
				<button type="button" class="btn btn-outline-warning active" data-bs-toggle="button"  aria-pressed="true" onclick="location.href='#'">비밀번호 찾기</button>
				<div class="border border-warning"></div>
			</div>
			<br>
			<div>
				<form onsubmit="findPassword(event)">
				<div class="mb-3 mt-3 d-flex justify-content-center ">
					<div class="d-flex flex-column">
						<label for="name">아이디:</label> 
						<input type="text" class="form-control" id="id" placeholder="아이디를 입력해주세요." required="required"  style="width:400px;">
					</div>
				</div>
				<br>
				<div class="mb-3 mt-3 d-flex justify-content-center">
					<div class="d-flex flex-column">
						<label for="name">이름:</label> 
						<input type="text" class="form-control" id="name" placeholder="이름을 입력해주세요." required="required" style="width:400px;">
					</div>	
				</div>
				<br>
				<div class="mb-3 mt-3 d-flex justify-content-center">
					<div style="width: 400px;">
						<label for="birthday">생년월일</label>&emsp;
						<input type="date" name="dateofbirth" required="required">
					</div>
				</div>
				<br>
				<div class="mb-3 d-flex justify-content-center ">
					<div class="d-flex flex-column">
						<label for="email">이메일</label> 
						<input type="email" class="form-control" id="email" placeholder="등록된 이메일을 입력해주세요"	required="required" style="width:400px;">
					</div>
				</div>
				<p style="text-align: center;">등록된 이메일 주소로 비밀번호가 전송됩니다.</p>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-success">&emsp;찾기&emsp;</button>
					<button type="button" class="btn btn-secondary" style="margin-left: 10px" onclick="location.href='#'">&emsp;취소&emsp;</button>
				</div>
				</form>
			</div>
		</div>
	</div>
				

	<!-- The Modal -->
	<div class="modal fade" id="pwdFindModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">비밀번호 찾기 완료</h4>
					<!-- <button type="button" class="btn-close" data-bs-dismiss="modal"></button>  -->
				</div>

				<!-- Modal body -->
				<div class="modal-body">등록된 이메일 주소로 비밀번호가 전송되었습니다.</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal" onclick="window.location.reload()">닫기</button>
				</div>

			</div>
		</div>
	</div>

</div>

<script>
	async function findPassword(event) {
		event.preventDefault();

		$("#pwdFindModal").modal('show');

	}
</script>

<%@ include file="../layout/footer.jsp"%>