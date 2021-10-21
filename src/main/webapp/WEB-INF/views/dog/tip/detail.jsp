<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>

<div class="container">
	<div class="card">
		<div class="card-header">
			<div class="d-flex justify-content-around">
				<div class="p-2">글 번호</div>
				<div class="p-2">글 제목</div>
				<div class="p-2">글 작성일</div>
				<div class="p-2">글 조회수</div>
			</div>
		</div>
		<div class="card-body">글 내용</div>
		<div class="card">
			<div class="card-header" style="text-align: center;">댓글 리스트</div>
			<ul id="reply-box" class="list-group">
				<li class="list-group-item d-flex justify-content-between">
					<div>댓글 내용</div>
					<div class="d-flex justify-content-between">
						<div class="font-italic">작성자 :</div>
						<button type="button" class="btn btn-secondary btn-sm">수정</button>&nbsp;
						<button type="button" class="btn btn-danger btn-sm">삭제</button>
					</div>
				</li>
			</ul>
			<div class="card-footer">
				<div class="input-group mb-3">
					  <span class="input-group-text">닉네임</span>
					<input type="text" class="form-control">
					<div class="input-group-append">
						<button class="btn btn-success" type="submit">등록</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ include file="../../layout/footer.jsp"%>