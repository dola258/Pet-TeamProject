<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>

<div class="container">
	<h1>고양이/자랑하기/디테일</h1>
	<h1>자랑하기</h1>
	<div class="card">
		<div class="card-header">
			<div class="d-flex justify-content-around">
				<div class="p-2">글 번호 : ${boastEntity.id}</div>
				<div class="p-2">글 제목 : ${boastEntity.title}</div>
				<div class="p-2">글 작성일 : ${boastEntity.user.username}</div>
				<div class="p-2">글 조회수 : ${boastEntity.counter}</div>
				
			<c:if test="sessionScope.principal.username == boastEntity.user.username">
				<div class="btn-group">
					<div class="btn-group">
						<button type="button" class="btn dropdown-toggle"
							data-bs-toggle="dropdown">더보기</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">수정하기</a></li>
							<li><a class="dropdown-item" href="#">삭제하기</a></li>
						</ul>
					</div>
				</div>
			</c:if>
			
			</div>
		</div>
		<div class="card-body" style="overflow: auto;">${boastEntity.content}</div>
		<div class="card">
			<div class="card-header" style="text-align: center;">댓글 리스트</div>
			<ul id="reply-box" class="list-group">
				<c:forEach var="comment" items="${boastEntity.comments }">
					<li class="list-group-item d-flex justify-content-between">
						<div>${comment.content }</div>
						<div class="d-flex justify-content-between">
							<div class="font-italic">작성자 : ${comment.user.username}</div>&emsp;
							<button type="button" class="btn btn-secondary btn-sm" id="reply_update-${comment.id}">수정</button>&nbsp;
							<button type="button" class="btn btn-danger btn-sm" id="reply_delete-${comment.id}">삭제</button>
						</div>
					</li>
				</c:forEach>
			</ul>
			<form action="/1/boast/${boastEntity.id}/comment" method="post">
				<div class="card-footer">
					<div class="input-group mb-3">
						<span class="input-group-text">${sessionScope.principal.username }</span>
						<input type="text" class="form-control" name="content">
						<div class="input-group-append">
							<button class="btn btn-success" type="submit">등록</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>


<%@ include file="../../layout/footer.jsp"%>