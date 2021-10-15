<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<h1>공지사항</h1>
	<div class="mt-4 p-5 bg-light text-white rounded">
		<input type="text" class="form-control" placeholder="제목을 입력하세요.">
		<hr class="bg-dark">
		<textarea class="form-control" rows="10" placeholder="내용을 입력하세요."></textarea>
		<hr class="bg-dark">
		<br />
		<div class="d-flex justify-content-end">
			<button type="button" class="btn btn-dark"
				onclick="location.href='#'">글작성</button>
			<button type="button" class="btn btn-secondary" style="margin-left: 20px" onclick="location.href='#'">취소</button>
		</div>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>