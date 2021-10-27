<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<h1>공지사항</h1>
	<div class="card">
		<div class="card-header">
			<div class="d-flex justify-content-around">
				<div class="p-2">글 번호</div>
				<div class="p-2">글 제목</div>
				<div class="p-2">글 작성일</div>
				<div class="p-2">글 조회수</div>

				<div class="btn-group">
					<div class="btn-group">
						<button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown">더보기</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">수정하기</a></li>
							<li><a class="dropdown-item" href="#">삭제하기</a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
		<div class="card-body">글 내용</div>
	</div>
</div>


<%@ include file="../layout/footer.jsp"%>