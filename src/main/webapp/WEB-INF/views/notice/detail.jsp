<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<h1>공지사항</h1>
	<div class="card">
		<div class="card-header">
			<div class="d-flex">
				<!-- <div class="p-2">번호: ${boastEntity.id}</div> -->
				<div class="p-2 flex-grow-1 bd-highlight">${noticeEntity.title}</div>

				
			<c:if test="${sessionScope.principal.username == noticeEntity.user.username}">
				<div class="btn-group">
					<div class="btn-group">
						<button type="button" class="btn dropdown-toggle"
							data-bs-toggle="dropdown">더보기</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/notice/${noticeEntity.id}/updateForm">수정하기</a></li>
							<li><a class="dropdown-item" onclick="deleteById(${noticeEntity.id})">삭제하기</a></li>
						</ul>
					</div>
				</div>
			</c:if>
			
			</div>
			<div class="d-flex font-size">
				<div class="p-2"><small>글 작성자 : ${noticeEntity.user.username}</small></div>
				<div class="p-2"><small>${parseCreatedAt}</small></div>
				<div class="p-2 "><small>조회 ${noticeEntity.counter}</small></div>
				<div class="flex-fill"></div>
			</div>
		</div>
		<div class="card-body" style="overflow: auto;">${noticeEntity.content}</div>
	</div>
</div>

<script>
	async function deleteById(id) {
	
		// 1. 비동기 함수 호출
		let response = await fetch("http://localhost:8080/notice/"+id, {
			method: "delete"
		});
		
		// 2. 코드
		let parseResponse = await response.json();
		console.log(parseResponse);
		
		if(parseResponse.code == 1) {
			alert("삭제성공");
			location.href= "/notice?page=0";
		} else {
			alert("삭제실패: "+parseResponse.msg);
		}
		
	
	}
</script>



<%@ include file="../layout/footer.jsp"%>