<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>

<style>

	@import url("/user_Css/button/btn-cancel.css");

</style>

<div class="container">
	<h1>댕댕이-자랑하기</h1>
	<form action="/2/boast" method="post" >
		<div class="mt-4 p-5 bg-light text-white rounded">
			<input type="text" class="form-control" name="title" placeholder="제목을 입력하세요.">
			<hr class="bg-dark">
			<textarea id="summernote" name="content" class="form-control" rows="10" placeholder="내용을 입력하세요." ></textarea>
			<hr class="bg-dark">
			<br />
			<div class="d-flex justify-content-end">
				<button type="submit" class="btn btn-success" >글작성</button>
				<button type="button" class="btn btn-secondary btn-cancel" onclick="location.href='/2/boast'">취소</button>
			</div>
		</div>
	</form>
</div>
<script>
	$('#summernote').summernote({
		placeholder : "내용을 입력하세요.(엔터 키를 누르면 크기가 늘어납니다.)",
		height: 350
	});
</script>


<%@ include file="../../layout/footer.jsp"%>