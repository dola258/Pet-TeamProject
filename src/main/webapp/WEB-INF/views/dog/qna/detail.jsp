<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>

<div class="container">
	<h1>댕댕이-QnA</h1>
	<div class="card">
		<div class="card-header">
			<div class="d-flex">
				<!-- <div class="p-2">번호: ${boastEntity.id}</div> -->
				<div class="p-2 flex-grow-1 bd-highlight">${qnaEntity.title}</div>

				
			<c:if test="${sessionScope.principal.username == qnaEntity.user.username || sessionScope.principal.authority eq 'admin'}">
				<div class="btn-group">
					<div class="btn-group">
						<button type="button" class="btn dropdown-toggle"
							data-bs-toggle="dropdown">더보기</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/2/qna/${qnaEntity.id}/updateForm">수정하기</a></li>
							<li><a class="dropdown-item" onclick="deleteById(${qnaEntity.id})">삭제하기</a></li>
						</ul>
					</div>
				</div>
			</c:if>
			
			</div>
			<div class="d-flex font-size">
				<div class="p-2"><small>글 작성자 : ${qnaEntity.user.username}</small></div>
				<div class="p-2"><small>${parseCreatedAt}</small></div>
				<div class="p-2 "><small>조회 ${qnaEntity.counter}</small></div>
				<div class="flex-fill"></div>
			</div>
		</div>
		<div class="card-body" style="overflow: auto;">${qnaEntity.content}</div>
		<div class="card">
			<div class="card-header" style="text-align: center;">댓글 리스트</div>
			<p></p>
			<c:forEach var="comment" items="${qnaEntity.comments }" >
				<ul id="reply-${comment.id}" class="list-group list-group-flush">
					<li class="list-group-item d-flex justify-content-between list-group-item-dark">
						<div class="d-flex ">
							<span class="font-italic">작성자 : ${comment.user.username}</span>&emsp;
							<div class="font-italic" id="commentCreatedAt"><fmt:parseDate value="${comment.createdAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" /><fmt:formatDate pattern="yyyy-MM-dd' 'HH:mm:ss" value="${ parsedDateTime }" /></div>&emsp;
							<c:if test="${sessionScope.principal.username == comment.user.username}">
								<button type="button" class="btn btn-danger btn-sm" onclick="reply_delete(${comment.id})">삭제</button>
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
			<form action="/2/qna/${qnaEntity.id}/comment" method="post">
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

<script>
	async function deleteById(id) {
	
		// 1. 비동기 함수 호출
		let response = await fetch("http://localhost:8080/qna/"+id, {
			method: "delete"
		});
		
		// 2. 코드
		let parseResponse = await response.json();
		console.log(parseResponse);
		
		if(parseResponse.code == 1) {
			alert("삭제성공");
			location.href= "/2/qna?page=0";
		} else {
			alert("삭제실패: "+parseResponse.msg);
		}
		
	
	}
</script>

<script>
	async function reply_delete(commentId) {
	
		// 1. 비동기 함수 호출
		let response = await fetch("http://localhost:8080/comment/"+commentId, {
			method: "delete"
		});
		
		// 2. 코드
		let parseResponse = await response.json();
		console.log(parseResponse);
		
		if(parseResponse.code == 1) {
			alert("삭제성공");
			$("#reply-"+commentId).remove();
		} else {
			alert("삭제실패: "+parseResponse.msg);
		}
		
	
	}
</script>


<%@ include file="../../layout/footer.jsp"%>