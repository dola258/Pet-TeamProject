<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
	<h1>고양이/자랑하기/디테일</h1>
	<h1>자랑하기</h1>
	<div class="card">
		<div class="card-header">
			<div class="d-flex">
				<!-- <div class="p-2">번호: ${boastEntity.id}</div> -->
				<div class="p-2 flex-grow-1 bd-highlight">${boastEntity.title}</div>

				
			<c:if test="${sessionScope.principal.username == boastEntity.user.username}">
				<div class="btn-group">
					<div class="btn-group">
						<button type="button" class="btn dropdown-toggle"
							data-bs-toggle="dropdown">더보기</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/1/boast/${boastEntity.id}/updateForm">수정하기</a></li>
							<li><a class="dropdown-item" href="#">삭제하기</a></li>
						</ul>
					</div>
				</div>
			</c:if>
			
			</div>
			<div class="d-flex font-size">
				<div class="p-2"><small>글 작성자 : ${boastEntity.user.username}</small></div>
				<div class="p-2"><small>${parseCreatedAt}</small></div>
				<div class="p-2 "><small>조회 ${boastEntity.counter}</small></div>
				<div class="flex-fill"></div>
			</div>
		</div>
		<div class="card-body" style="overflow: auto;">${boastEntity.content}</div>
		<div class="card">
			<div class="card-header" style="text-align: center;">댓글 리스트</div>
			<p></p>
			<c:forEach var="comment" items="${boastEntity.comments }" >
				<ul id="reply-box " class="list-group list-group-flush">
					<li class="list-group-item d-flex justify-content-between list-group-item-dark">
						<div class="d-flex ">
							<span class="font-italic">작성자 : ${comment.user.username}</span>&emsp;
							<div class="font-italic" id="commentCreatedAt"><fmt:parseDate value="${comment.createdAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" /><fmt:formatDate pattern="yyyy-MM-dd' 'HH:mm:ss" value="${ parsedDateTime }" /></div>&emsp;
							<c:if test="${sessionScope.principal.username == comment.user.username}">
								<button type="button" class="btn btn-secondary btn-sm" id="reply_update-${comment.id}">수정</button>&nbsp;
								<button type="button" class="btn btn-danger btn-sm" id="reply_delete-${comment.id}">삭제</button>
							</c:if>
						</div>
					</li>
					<li class="list-group-item d-flex justify-content-between list-group-item-secondary">
						<div class="d-flex justify-content-between">
							<p>${comment.content }</p>
						</div>
					</li>
				</ul>
				<p></p>
			</c:forEach>
			<c:if test="${!empty sessionScope.principal.username}">
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
			</c:if>
		</div>
	</div>
</div>


<%@ include file="../../layout/footer.jsp"%>