<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>

<style>

	@import url("/user_Css/button/btn-cancel.css");

</style>

<div class="container">
	<h1>댕댕이-자랑하기</h1>
	<form onsubmit="update(event, ${boastEntity.id})" >
		<div class="mt-4 p-5 bg-light text-white rounded">
			 <input id="title" type="text"  value="${boastEntity.title}" class="form-control" placeholder="제목을 입력하세요.">
			<hr class="bg-dark">
			<textarea id="content" class="form-control" rows="10" placeholder="내용을 입력하세요.">${boastEntity.content}</textarea>
			<hr class="bg-dark">
			<br />
			<div class="d-flex justify-content-end">
				<button type="submit" class="btn btn-success" >글수정</button>
				<button type="button" class="btn btn-secondary btn-cancel" onclick="location.href='http://localhost:8080/2/boast?page=0'">취소</button>
			</div>
		</div>
	</form>
</div>

<script>
async function update(event, id){ 
	
	   event.preventDefault();

	   let boastUpdateDto = {
			   title: document.querySelector("#title").value,
			   content: document.querySelector("#content").value,
	   };

		console.log(boastUpdateDto);
	
		let response = await fetch("http://localhost:8080/2/boast/"+id, {
			method: "put",
			body: JSON.stringify(boastUpdateDto),
			headers: {
				"Content-Type": "application/json; charset=utf-8"
			}
		});
		
		let parseResponse = await response.json(); 
	
		console.log(parseResponse);
		
		if(parseResponse.code == 1){
			alert("업데이트 성공");
			location.href = "/2/boast/"+id
		}else{
			alert("업데이트 실패");
			alert("업데이트 실패 : "+parseResponse.msg);
		}
}

	$('#content').summernote({
		placeholder : "내용을 입력하세요.(엔터 키를 누르면 크기가 늘어납니다.)",
		height: 350
	});
</script>

<%@ include file="../../layout/footer.jsp"%>