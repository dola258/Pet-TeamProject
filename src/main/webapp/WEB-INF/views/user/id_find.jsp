<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<div class="container">

	<button type="button" class="btn btn-outline-success active"
		data-bs-toggle="button" aria-pressed="true"
		onclick="location.href='#'">아이디 찾기</button>
	<button type="button" class="btn btn-outline-warning"
		onclick="location.href='#'">비밀번호 찾기</button>

	<div class="border border-success"></div>
	<form onsubmit="findId(event)">
		<div class="mb-3 mt-3">
			<label for="name">이름:</label> <input type="text" class="form-control"
				id="name" placeholder="이름을 입력해주세요." required="required">
		</div>
		<div class="mb-3 mt-3">
			<label for="birthday">생년월일:</label><br />
			<input type="date" name="dateofbirth" required="required">
		</div>
		<div class="mb-3">
			<label for="email">이메일:</label> <input type="email"
				class="form-control" id="email" placeholder="등록된 이메일을 입력해주세요"
				required="required">
		</div>
		<p style="text-align: center;">등록된 이메일 주소로 아이디가 전송됩니다.</p>
		<div class="d-flex justify-content-center">
			<button type="submit" class="btn btn-primary">&emsp;찾기&emsp;</button>
			<button type="button" class="btn btn-secondary"
				style="margin-left: 10px" onclick="location.href='#'">&emsp;취소&emsp;</button>
		</div>
	</form>

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
				<div class="modal-body">등록된 이메일 주소로 아이디가 전송되었습니다.</div>

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
	async
	function findId(event) {
		event.preventDefault();

		$("#idFindModal").modal('show');

	}
</script>

<%@ include file="../layout/footer.jsp"%>